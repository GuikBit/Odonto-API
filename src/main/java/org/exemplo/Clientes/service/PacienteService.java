package org.exemplo.Clientes.service;

import org.exemplo.Clientes.model.Entity.infoPaciente.Anamnese;
import org.exemplo.Clientes.model.Entity.Paciente;
import org.exemplo.Clientes.model.Entity.infoPaciente.Endereco;
import org.exemplo.Clientes.model.Entity.Responsavel;
import org.exemplo.Clientes.model.repository.AnamneseRepository;
import org.exemplo.Clientes.model.repository.PacienteRepository;
import org.exemplo.Clientes.model.repository.EnderecoRepository;
import org.exemplo.Clientes.model.repository.FamiliaresRepository;
import org.exemplo.Clientes.rest.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    AnamneseRepository anamneseRepository;
    @Autowired
    FamiliaresRepository familiaresRepository;

    public Paciente salvarNovoPaciente(ClienteDTO clienteDTO) {

        Paciente novo = salvaPaciente(clienteDTO);
        salvarEndereco(clienteDTO, novo);
        salvarResp(clienteDTO, novo);
        salvarAnamnese(clienteDTO, novo);

        return novo;
    }

    private Paciente salvaPaciente(ClienteDTO clienteDTO) {


           Paciente novo = new Paciente();

           novo.setUsername(clienteDTO.getLogin());
           novo.setPassword(clienteDTO.getSenha());
           novo.setNSerie(clienteDTO.getNSerie());
           novo.setNome(clienteDTO.getNome());
           novo.setCpf(clienteDTO.getCpf());
           novo.setDataNascimento(LocalDate.parse(clienteDTO.getDataNascimento()));
           novo.setTelefone(clienteDTO.getTelefone());
           novo.setEmail(clienteDTO.getEmail());
           if(novo != null){
               return pacienteRepository.save(novo);
           }
       return null;
    }

    public Paciente buscaPorId(Integer id) {
        return pacienteRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    public void deletarPacientePorId(Integer id) {
        pacienteRepository
                .findById(id)
                .map(cliente->{
                    pacienteRepository.delete(cliente);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    public void atualizaDadosPorId(Integer id, ClienteDTO novoCliente) {
        pacienteRepository
                .findById(id)
                .map( Cliente ->
                {
                    atualizarCliente(novoCliente, Cliente.getId());
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }



    private void atualizarCliente(ClienteDTO clienteDTO, Integer id){

        Paciente novo = new Paciente();

        novo.setId(id);
        preecheCliente(clienteDTO, novo);

        pacienteRepository.save(novo);
    }


    private Paciente salvarCliente(ClienteDTO clienteDTO){

        Paciente novo = new Paciente();
        preecheCliente(clienteDTO, novo);

        return pacienteRepository.save(novo);
    }
    private static void preecheCliente(ClienteDTO clienteDTO, Paciente novo) {

        novo.setNome(clienteDTO.getNome());
        novo.setCpf(clienteDTO.getCpf());
        novo.setDataNascimento(LocalDate.parse(clienteDTO.getDataNascimento()));
        novo.setTelefone(clienteDTO.getTelefone());
    }
    private void salvarEndereco(ClienteDTO clienteDTO, Paciente cliente){

        Endereco end = new Endereco();

        end.setCliente(cliente);
        end.setCidade(clienteDTO.getCidade());
        end.setBairro(clienteDTO.getBairro());
        end.setCep(clienteDTO.getCep());
        end.setLogradouro(clienteDTO.getLogradouro());
        end.setNumero(clienteDTO.getNumero());
        end.setComplemento(clienteDTO.getComplemento());
        end.setReferencia(clienteDTO.getReferencia());
        if ((end != null)) {
            enderecoRepository.save(end);
        }

    }
    private void salvarResp(ClienteDTO clienteDTO, Paciente novo) {

        Responsavel resp = new Responsavel();

        resp.setCliente(novo);
        resp.setNomeResp(clienteDTO.getNomeResp());
        resp.setCpfResp(clienteDTO.getCpfResp());
        resp.setTelefoneResp(clienteDTO.getTelResp());

        if((resp != null)){
            familiaresRepository.save(resp);
        }

    }

    private void salvarAnamnese(ClienteDTO clienteDTO, Paciente novo){

        Anamnese anam = new Anamnese();

        anam.setCliente(novo);
        anam.setAlergicoMedic(clienteDTO.getAlergicoMedic());
        anam.setTratMedico(clienteDTO.getTratMedico());
        anam.setNomeTrat(clienteDTO.getNomeTrat());
        anam.setUsaMedic(clienteDTO.getUsaMedic());
        anam.setAlergicoMedic(clienteDTO.getAlergicoMedic());
        anam.setSangramentoExcessivo(clienteDTO.isSangramentoExcessivo());
        anam.setHipertenso(clienteDTO.isHipertenso());
        anam.setGravida(clienteDTO.isGravida());
        anam.setTraumatismoFace(clienteDTO.isTraumatismoFace());

        if((anam != null)){

            anamneseRepository.save(anam);
        }
    }

    public Page<Paciente> buscaTodosPacientesHome(Pageable pageable) {
        Page<Paciente> lista = pacienteRepository.findAll(pageable).map(Paciente:: new);
        return  lista;
    }
}
