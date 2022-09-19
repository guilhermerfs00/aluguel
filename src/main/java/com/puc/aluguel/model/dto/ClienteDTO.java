package com.puc.aluguel.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO extends UsuarioDTO {

    private String cpf;
    private String rg;
    private String nome;
    private String endereco;
    private List<EmpregadoresDTO> empregadoresDTO;

}