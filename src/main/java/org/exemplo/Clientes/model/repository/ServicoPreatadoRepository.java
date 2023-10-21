package org.exemplo.Clientes.model.repository;

import org.exemplo.Clientes.model.Entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPreatadoRepository extends JpaRepository <Consulta, Integer> {
    @Query("select s from Consulta s join s.cliente c where upper(c.nome) like upper(:nome) and MONTH(s.data) =:mes")
    List<Consulta> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);

    @Query("select s from Consulta s join s.cliente c where upper(c.nome) like upper(:nome)")
    List<Consulta> findByNomeCliente(@Param("nome") String nome);
    @Query("select s from Consulta s where MONTH(s.data) =:mes")
    List<Consulta> findByMes(Integer mes);
}
