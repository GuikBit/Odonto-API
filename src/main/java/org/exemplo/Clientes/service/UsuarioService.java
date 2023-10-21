package org.exemplo.Clientes.service;


import org.exemplo.Clientes.exception.UsuarioCadastradoException;
import org.exemplo.Clientes.model.Entity.Paciente;
import org.exemplo.Clientes.model.Entity.Usuario;
import org.exemplo.Clientes.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    public Paciente salvar(Paciente usuario){
        boolean exists = repository.existsByUsername(usuario.getUsername());
        if(exists){
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        return repository.save(usuario);
    }

    public List<Paciente> buscaAll(){
        return repository.findAll();
    }

    @Autowired
    private UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Paciente usuario = repository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Login não encontrado!"));

        return User.builder().username(usuario.getUsername()).password(usuario.getPassword()).roles("USER").build();
    }
}
