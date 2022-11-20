package med.voll.api.model.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	public Endereco(DadosEnderecoDTO dados) {
		this.logradouro = dados.logradouro();
		this.numero = dados.numero();
		this.complemento = dados.complemento();
		this.cep = dados.cep();
		this.bairro = dados.bairro();
		this.cidade = dados.cidade();
		this.uf = dados.uf();
	}
	
	private String logradouro;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String numero;
	private String complemento;

}
