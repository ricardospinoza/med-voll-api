package med.voll.api.model.paciente;

import jakarta.validation.Valid;
import med.voll.api.model.endereco.DadosEnderecoDTO;

public record DadosAtualizacaoPaciente(Long id, String nome, String telefone, @Valid DadosEnderecoDTO endereco) {}
