package com.puc.aluguel.repository;

import com.puc.aluguel.model.entity.Automovel;
import com.puc.aluguel.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
}