package org.exemplo.Clientes.model.repository;

import org.exemplo.Clientes.model.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
