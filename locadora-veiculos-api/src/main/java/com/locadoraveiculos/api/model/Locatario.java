package com.locadoraveiculos.api.model;

import com.locadoraveiculos.api.dto.CadastroLocatarioDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locatarios")
public class Locatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    @OneToMany(mappedBy = "tutor")
    private List<Locacao> locacoes = new ArrayList<>();

    public Locatario() {
    }

    public Locatario(CadastroLocatarioDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }
}
