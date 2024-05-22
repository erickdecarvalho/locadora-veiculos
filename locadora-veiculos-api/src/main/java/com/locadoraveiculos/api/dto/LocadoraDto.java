package com.locadoraveiculos.api.dto;

import com.locadoraveiculos.api.model.Locadora;

public record LocadoraDto(Long id, String nome, String telefone, String email) {

    public LocadoraDto(Locadora locadora) {
        this(locadora.getId(), locadora.getNome(), locadora.getTelefone() ,locadora.getEmail());
    }
}
