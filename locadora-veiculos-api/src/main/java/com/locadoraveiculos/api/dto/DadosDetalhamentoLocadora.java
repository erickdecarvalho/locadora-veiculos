package com.locadoraveiculos.api.dto;

import com.locadoraveiculos.api.model.Locadora;

public record DadosDetalhamentoLocadora(Long id, String nome, String telefone, String email) {
    public DadosDetalhamentoLocadora(Locadora locadora) {
        this(locadora.getId(), locadora.getNome(), locadora.getTelefone(), locadora.getEmail());

    }
}
