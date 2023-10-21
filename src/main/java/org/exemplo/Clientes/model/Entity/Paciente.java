package org.exemplo.Clientes.model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 20)
    private int nSerie;
    @Column(unique = true, name="login", nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 150, name="senha")
    private String password;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, length = 11, updatable = false)
    private String cpf;
    @Column(nullable = false, length = 20)
    private LocalDate dataNascimento;
    @Column(nullable = false, length = 20)
    private LocalDate dataCadastro;
    @Column(nullable = false, length = 15)
    private String telefone;

    @PrePersist
    public void prePersiste(){
        setDataCadastro(LocalDate.now());
    }


    public Paciente(Paciente paciente) {
        this.id = paciente.id;
        this.nSerie = paciente.nSerie;
        this.username = paciente.username;
        this.password = paciente.password;
        this.email = paciente.email;
        this.nome = paciente.nome;
        this.cpf = paciente.cpf;
        this.dataNascimento = paciente.dataNascimento;
        this.dataCadastro = paciente.dataCadastro;
        this.telefone = paciente.telefone;
    }
}
