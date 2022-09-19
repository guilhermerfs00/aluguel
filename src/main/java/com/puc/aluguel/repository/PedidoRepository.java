package com.puc.aluguel.repository;

import com.puc.aluguel.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE " +
            "(:id is null or p.id = :id) " +
            "and (:nomeCliente is null or p.cliente.nome = :nomeCliente)" +
            "and (:nomeAgente is null or p.agente.nome = :nomeAgente)")
    List<Pedido> pedidoFiltro(@Param("id") Long id,
                              @Param("nomeCliente") String nomeCliente,
                              @Param("nomeAgente") String nomeAgente);

}