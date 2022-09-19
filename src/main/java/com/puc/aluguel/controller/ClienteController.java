package com.puc.aluguel.controller;


import com.puc.aluguel.model.dto.ClienteDTO;
import com.puc.aluguel.model.dto.PedidoDTO;
import com.puc.aluguel.model.enums.TipoRegistroEnum;
import com.puc.aluguel.services.ClienteService;
import com.puc.aluguel.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value = "/criar-cliente")
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        var response = service.criarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(value = "/introduzir-pedido/{idAutomovel}/{tipoRegistro}/{idCliente}")
    public ResponseEntity introduzirPedido(@PathVariable("idAutomovel") Long idAutomovel,
                                           @PathVariable("tipoRegistro") TipoRegistroEnum tipoRegistroEnum,
                                           @PathVariable("idCliente") Long idCliente) {

        var response = pedidoService.criarPedido(idAutomovel, idCliente, tipoRegistroEnum);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(value = "/consultar-pedido/{id}/{nomeCliente}/{nomeAgente}")
    public ResponseEntity consultarPedido(@RequestParam(value = "id", required = false) Long id,
                                          @RequestParam(value = "nomeCliente", required = false) String nomeCliente,
                                          @RequestParam(value = "nomeAgente", required = false) String nomeAgente) {

        var response = pedidoService.filtrarPedido(id, nomeCliente, nomeAgente);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}