package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.medico.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
