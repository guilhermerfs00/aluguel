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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agente_id", referencedColumnName = "id")
    private Agente agente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "automovel_id", referencedColumnName = "id")
    private Automovel automovel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contrato_id", referencedColumnName = "id")
    private Contrato contrato;

}