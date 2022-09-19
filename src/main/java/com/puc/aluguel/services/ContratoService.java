package com.puc.aluguel.services;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.mapper.AutomovelMapper;
import com.puc.aluguel.mapper.ContratoMapper;
import com.puc.aluguel.model.dto.AutomovelDTO;
import com.puc.aluguel.model.dto.ContratoDTO;
import com.puc.aluguel.repository.AutomovelRepository;
import com.puc.aluguel.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {

    @Autowired
    ContratoRepository repository;

    public ContratoDTO gerarContrato(ContratoDTO contratoDTO) {
        var contrato = repository.save(ContratoMapper.INSTANCE.dtoToEntity(contratoDTO));
        return ContratoMapper.INSTANCE.entityToDto(contrato);
    }
}