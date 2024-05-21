package com.locadoraveiculos.api.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "locacoes")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    @ManyToOne(fetch = FetchType.LAZY)
    private Locatario locatario;

    @OneToOne(fetch = FetchType.LAZY)
    private Veiculo veiculo;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private StatusLocacao statusLocacao;

    private String justificativaStatus;


}