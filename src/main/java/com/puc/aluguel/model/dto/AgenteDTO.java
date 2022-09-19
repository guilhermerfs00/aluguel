package com.puc.aluguel.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenteDTO extends UsuarioDTO {

    private Long id;
    private String nome;

}