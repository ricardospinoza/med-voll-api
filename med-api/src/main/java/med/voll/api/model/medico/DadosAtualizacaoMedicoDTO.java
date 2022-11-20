package med.voll.api.model.medico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.endereco.DadosEnderecoDTO;

public record DadosAtualizacaoMedicoDTO(
		
		@NotNull
		Long id,
		
		String nome, 
		
		@Pattern(regexp = "\\d{10}")
		String telefone,
		
		DadosEnderecoDTO endereco
		
		) {

}
