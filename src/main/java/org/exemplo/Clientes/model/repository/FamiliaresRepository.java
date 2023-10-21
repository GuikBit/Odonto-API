package org.exemplo.Clientes.model.repository;

import org.exemplo.Clientes.model.Entity.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaresRepository extends JpaRepository<Responsavel, Integer> {
}
