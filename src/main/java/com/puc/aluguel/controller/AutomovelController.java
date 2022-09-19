package com.puc.aluguel.controller;


import com.puc.aluguel.model.dto.AutomovelDTO;
import com.puc.aluguel.model.dto.ClienteDTO;
import com.puc.aluguel.model.enums.TipoRegistroEnum;
import com.puc.aluguel.services.AutomovelService;
import com.puc.aluguel.services.ClienteService;
import com.puc.aluguel.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutomovelController {

    @Autowired
    private AutomovelService service;


    @GetMapping(value = "/buscar-todos-automoveis")
    public ResponseEntity<List<AutomovelDTO>> buscarTodosAutomoveis() {
        var response = service.buscarTodos();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(value = "/salvar-automoveis")
    public ResponseEntity<List<AutomovelDTO>> salvarAutomoveis() {
        service.salvarListAutomoveis();
        return ResponseEntity.ok().build();
    }

}