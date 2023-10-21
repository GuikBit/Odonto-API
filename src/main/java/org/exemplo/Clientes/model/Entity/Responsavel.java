package org.exemplo.Clientes.model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Paciente cliente;
    @Column
    private String nomeResp;
    @Column
    private String cpfResp;
    @Column
    private String telefoneResp;

}
