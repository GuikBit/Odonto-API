package org.exemplo.Clientes.model.Entity.infoPaciente;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.exemplo.Clientes.model.Entity.Paciente;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Paciente cliente;
    @Column
    private String cidade;
    @Column
    private String bairro;
    @Column
    private String logradouro;
    @Column
    private String cep;
    @Column
    private String numero;
    @Column
    private String complemento;
    @Column
    private String referencia;
}
