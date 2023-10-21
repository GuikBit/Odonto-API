package org.exemplo.Clientes.rest;

import lombok.RequiredArgsConstructor;
import org.exemplo.Clientes.exception.UsuarioCadastradoException;
import org.exemplo.Clientes.model.Entity.Paciente;
import org.exemplo.Clientes.model.Entity.Usuario;

import org.exemplo.Clientes.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Paciente usuario)
    {
        try{
            service.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    public List<Paciente> busca()
    {
        return service.buscaAll();
    }


}
