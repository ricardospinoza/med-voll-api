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
import med.voll.api.model.paciente.DadosAtualizacaoPaciente;
import med.voll.api.model.paciente.DadosCadastroPacienteDTO;
import med.voll.api.model.paciente.DadosListagemPacienteDTO;
import med.voll.api.model.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPacienteDTO dados) {
    	repository.save(new Paciente(dados));
    }
    
    @GetMapping
    public Page<DadosListagemPacienteDTO> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPacienteDTO::new);
    }
    
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inativar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }
    
}