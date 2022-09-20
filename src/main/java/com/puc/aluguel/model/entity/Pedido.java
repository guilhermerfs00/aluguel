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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agente_id", referencedColumnName = "id")
    private Agente agente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cidade_id", referencedColumnName = "id")
    private Automovel automovel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contrato_id", referencedColumnName = "id")
    private Contrato contrato;

}