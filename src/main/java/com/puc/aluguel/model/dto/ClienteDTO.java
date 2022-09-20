package com.puc.aluguel.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private String cpf;
    private String rg;
    private String nome;
    private String endereco;
    private List<EmpregadoresDTO> empregadores;

}