package com.puc.aluguel.services;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.mapper.ClienteMapper;
import com.puc.aluguel.model.dto.ClienteDTO;
import com.puc.aluguel.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        var patient = repository.save(ClienteMapper.INSTANCE.dtoToEntity(clienteDTO));
        return ClienteMapper.INSTANCE.entityToDto(patient);
    }

    public ClienteDTO buscarClienteDTOPorId(Long idCliente) {
        var cliente = repository.findById(idCliente).orElseThrow(() -> new BusinesException("Erro ao buscar pedido"));
        return ClienteMapper.INSTANCE.entityToDto(cliente);
    }
}