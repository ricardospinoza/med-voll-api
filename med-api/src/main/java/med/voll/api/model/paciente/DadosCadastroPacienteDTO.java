package med.voll.api.model.paciente;

import med.voll.api.model.endereco.DadosEnderecoDTO;

public record DadosCadastroPacienteDTO(String nome,
        String email,
        String telefone,
        String cpf,
        DadosEnderecoDTO endereco) {

}
