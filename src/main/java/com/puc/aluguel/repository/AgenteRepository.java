package com.puc.aluguel.repository;

import com.puc.aluguel.model.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long> {
}