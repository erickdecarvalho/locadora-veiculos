package com.locadoraveiculos.api.model;

import com.locadoraveiculos.api.dto.CadastroVeiculoDto;
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

    public Veiculo() {
    }

    public Veiculo(CadastroVeiculoDto dto, Locadora locadora) {
        this.tipo = dto.tipoVeiculo();
        this.nome = dto.nome();
        this.chassi = dto.chassi();
        this.ano = dto.ano();
        this.cor = dto.cor();
        this.peso = dto.peso();
        this.locadora = locadora;
        this.alugado = false;
    }

    public Long getId() {
        return id;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getChassi() {
        return chassi;
    }

    public Integer getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public Float getPeso() {
        return peso;
    }

    public Boolean getAlugado() {
        return alugado;
    }
}
