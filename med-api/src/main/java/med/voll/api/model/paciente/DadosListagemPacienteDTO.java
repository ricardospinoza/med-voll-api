package med.voll.api.model.paciente;

public record DadosListagemPacienteDTO(String nome, String email, String cpf, String telefone) {
    public DadosListagemPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
	
}