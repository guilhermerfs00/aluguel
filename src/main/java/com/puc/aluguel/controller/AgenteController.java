package com.puc.aluguel.controller;


import com.puc.aluguel.model.dto.AgenteDTO;
import com.puc.aluguel.model.dto.AgentePedidoDTO;
import com.puc.aluguel.services.AgenteService;
import com.puc.aluguel.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AgenteController {

    @Autowired
    private AgenteService service;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value = "/criar-agente")
    public ResponseEntity<AgenteDTO> criarAgente(@RequestBody AgenteDTO agenteDTO) {
        var response = service.criarAgente(agenteDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping(value = "/avaliar-pedido")
    public ResponseEntity<AgenteDTO> avaliarPedido(@RequestBody AgentePedidoDTO agentePedidoDTO) {
        var response = pedidoService.avaliarPedido(agentePedidoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}