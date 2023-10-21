package org.exemplo.Clientes.model.Entity.infoPaciente;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.exemplo.Clientes.model.Entity.Paciente;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Outros  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Paciente cliente;
    @Column
    private String queixaPrincipal;
    @Column
    private String dataUltimoExame;
    @Column
    private String frequenciaDentista;
    @Column
    private String higieneBucal;
    @Column
    private String frequenciaEscovacao;
    @Column
    private String habitos;
    @Column
    private String observacao;
}
