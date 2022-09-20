package com.puc.aluguel.model.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "pedido")
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "concideracaoAgente")
    private String concideracaoAgente;

    @Column(name = "parecer")
    private Boolean parecer;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "agente_id")
    private Agente agente;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="cidade_id")
    private Automovel automovel;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

}