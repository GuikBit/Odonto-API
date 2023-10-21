package org.exemplo.Clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ClienteDTO {

    private int id;
    private int nSerie;
    private String login;
    private String senha;
    private String email;
    private String nome;
    private String cpf;
    private String dataCadastro;
    private String dataNascimento;
    private String telefone;

    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String cep;
    private String complemento;
    private String referencia;

    private String nomeResp;
    private String cpfResp;
    private String telResp;

    //Anamnese

    private String porDoenca;
    private String tratMedico;
    private String nomeTrat;
    private String usaMedic;
    private String alergicoMedic;
    private boolean sangramentoExcessivo;
    private boolean hipertenso;
    private boolean gravida;
    private boolean traumatismoFace;
    //outros

//    private String queixaPrincipal;
//
//    private String dataUltimoExame;
//
//    private String frequenciaDentista;
//
//    private String higieneBucal;
//
//    private String frequenciaEscovacao;
//
//    private String habitos;
//
//    private Long observacao;


}
