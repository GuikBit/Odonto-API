package org.exemplo.Clientes.model.repository;

import org.exemplo.Clientes.model.Entity.infoPaciente.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
