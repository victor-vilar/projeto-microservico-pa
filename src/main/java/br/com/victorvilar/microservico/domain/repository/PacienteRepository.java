package br.com.victorvilar.microservico.domain.repository;

import br.com.victorvilar.microservico.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {

}
