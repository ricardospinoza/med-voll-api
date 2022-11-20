package med.voll.api.model.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endereco.Endereco;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
	
	
	public Paciente(DadosCadastroPacienteDTO dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Boolean ativo;
	@Embedded
	private Endereco endereco;
	public void inativar() {
		this.ativo = false;		
	}
	public void atualizarInformacoes(@Valid DadosAtualizacaoPaciente dados) {
		if (dados.nome()!=null)
			this.nome = dados.nome();
		if (dados.telefone()!=null)
			this.telefone=dados.telefone();
		if (dados.endereco()!=null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
		
	}

}
