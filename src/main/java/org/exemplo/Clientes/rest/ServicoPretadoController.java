package org.exemplo.Clientes.rest;

import lombok.RequiredArgsConstructor;
import org.exemplo.Clientes.model.Entity.Paciente;
import org.exemplo.Clientes.model.Entity.Consulta;
import org.exemplo.Clientes.model.repository.PacienteRepository;
import org.exemplo.Clientes.model.repository.ServicoPreatadoRepository;
import org.exemplo.Clientes.rest.dto.ServicoPresatadoDTO;
import org.exemplo.Clientes.util.bigDecimalConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor

public class ServicoPretadoController {

    private final PacienteRepository clienteRepository;
    private final ServicoPreatadoRepository repository;
    private final bigDecimalConverter bigDecimalConverter;
    private final ServicoPreatadoRepository servicoPreatadoRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta salvar(@RequestBody @Valid ServicoPresatadoDTO dto){
       LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

       Paciente cliente = clienteRepository.findById(dto.getIdCliente()).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente!"));


       Consulta servicoPrestado = new Consulta();
       servicoPrestado.setDescriçãoAtendimento(dto.getDescricao());
       servicoPrestado.setData( data );
       servicoPrestado.setCliente(cliente);
       servicoPrestado.setDentista(dto.getDescricao());

       return repository.save(servicoPrestado);
   }
    @GetMapping
    public List<Consulta> pesquisar(
            @RequestParam(value ="nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        if(nome == null )
            return repository.findByMes(mes);
        if(mes == null)
            return repository.findByNomeCliente("%"+nome+"%");
        return repository.findByNomeClienteAndMes("%"+nome+"%", mes);
    }
}
