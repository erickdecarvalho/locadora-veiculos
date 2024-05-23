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

    @Enumerated(EnumType.STRING)
    private Status status;

    private String justificativaStatus;

    public Locacao() {
    }

    public Locacao(Locatario locatario, Veiculo veiculo) {
        this.locatario = locatario;
        this.veiculo = veiculo;
        this.status = Status.AGUARDANDO_AVALIACAO;
        this.data = LocalDateTime.now();
    }

    public void marcarComoAprovada() {
        this.status = Status.APROVADO;
    }

    public void marcarComoReprovada(String justificativa) {
        this.status = Status.REPROVADO;
        this.justificativaStatus = justificativa;
    }
}
