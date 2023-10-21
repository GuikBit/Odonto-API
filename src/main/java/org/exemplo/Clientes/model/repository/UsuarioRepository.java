package org.exemplo.Clientes.model.repository;

import org.exemplo.Clientes.model.Entity.Paciente;
import org.exemplo.Clientes.model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByUsername(String username);

    boolean existsByUsername(String username);
}
