package org.exemplo.Clientes.model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name="login")
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String username;

    @Column(name="senha")
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String password;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;


    @PrePersist
    public void prePersiste(){
        setDataCadastro(LocalDate.now());
    }

}
