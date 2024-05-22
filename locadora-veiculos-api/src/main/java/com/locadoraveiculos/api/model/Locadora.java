package com.locadoraveiculos.api.model;

import com.locadoraveiculos.api.dto.CadastroLocadoraDto;
import jakarta.persistence.*;

@Entity
@Table(name = "locadoras")
public class Locadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    public Locadora() {
    }

    public Locadora(CadastroLocadoraDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void atualizarNome(String nome) {
        this.nome = nome;
    }

    public void atualizarTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void atualizarEmail(String email) {
        this.email = email;
    }
}
