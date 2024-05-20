package com.locadoraveiculos.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;

    private String nome;

    private String chassi;

    private Integer ano;

    private String cor;

    private Float peso;

    private Boolean alugado;

    @ManyToOne(fetch = FetchType.LAZY)
    private Locadora locadora;

    @OneToOne(mappedBy = "veiculo", fetch = FetchType.LAZY)
    private Locacao locacao;

}
