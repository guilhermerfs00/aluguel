package com.puc.aluguel.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomovelDTO {

    private String matricula;
    private Integer ano;
    private String marca;
    private String modelo;
    private String placa;

}