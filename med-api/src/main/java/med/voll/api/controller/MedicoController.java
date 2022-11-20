package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.model.medico.DadosAtualizacaoMedicoDTO;
import med.voll.api.model.medico.DadosCadastroMedicoDTO;
import med.voll.api.model.medico.DadosListagemMedicoDTO;
import med.voll.api.model.medico.Medico;
import med.voll.api.repository.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados) {
		repository.save(new Medico(dados));
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicoDTO dados) {
		
		var medico = repository.getReferenceById(dados.id());
		medico.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void inativar(@PathVariable Long id) {
		var medico = repository.getReferenceById(id);
		medico.inativar();
	}
	
	@GetMapping
	public Page<DadosListagemMedicoDTO> listar(@PageableDefault(size=10, sort= {"nome"}) Pageable paginacao) {
		//return repository.findAll(paginacao).stream().map(DadosListagemMedicoDTO::new).toList();
		//http://localhost:8080/medicos?size=1&page=0
		//size nro de elementos por página
		//page começando em 0, seta qual pagina será retornada
		//http://localhost:8080/medicos?sort=nome,desc ordenação por atributo, asc desc
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicoDTO::new);
	}
}
