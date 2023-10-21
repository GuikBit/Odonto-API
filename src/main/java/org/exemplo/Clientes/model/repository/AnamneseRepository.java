package org.exemplo.Clientes.model.repository;

import org.exemplo.Clientes.model.Entity.infoPaciente.Anamnese;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnamneseRepository extends JpaRepository<Anamnese, Integer> {
}
