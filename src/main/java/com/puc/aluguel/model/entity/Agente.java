package com.puc.aluguel.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Table(name = "agente")
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

}