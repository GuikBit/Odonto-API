package org.exemplo.Clientes.rest;


import org.exemplo.Clientes.model.Entity.Paciente;
import org.exemplo.Clientes.rest.dto.ClienteDTO;
import org.exemplo.Clientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class PacienteController {


    @Autowired
    PacienteService pacienteService;



    @PostMapping("/novoPaciente")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody @Valid ClienteDTO clienteDTO)
    {
        Paciente novo = pacienteService.salvarNovoPaciente(clienteDTO);

        return novo;
    }



    @GetMapping("{id}")
    public Paciente BuscaPorId(@PathVariable Integer id)
    {
        return pacienteService.buscaPorId(id);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Integer id){

        pacienteService.deletarPacientePorId(id);
    }
    @GetMapping("/buscaAll")
    public Page<Paciente> buscaAll(Pageable pageable){
        Page<Paciente> lista = pacienteService.buscaTodosPacientesHome(pageable);
        return lista;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaDados (@PathVariable Integer id, @RequestBody @Valid ClienteDTO novoCliente){

        pacienteService.atualizaDadosPorId(id, novoCliente);

    }


}
