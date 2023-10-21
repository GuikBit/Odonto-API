package org.exemplo.Clientes.model.Entity.infoPaciente;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.exemplo.Clientes.model.Entity.Paciente;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Anamnese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Paciente cliente;
    @Column
    private String porDoenca;
    @Column
    private String tratMedico;
    @Column
    private String nomeTrat;
    @Column
    private String usaMedic;
    @Column
    private String alergicoMedic;
    @Column
    private boolean sangramentoExcessivo;
    @Column
    private boolean hipertenso;
    @Column
    private boolean gravida;
    @Column
    private boolean traumatismoFace;
}
