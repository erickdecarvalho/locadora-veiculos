package com.locadoraveiculos.api.dto;

import com.locadoraveiculos.api.model.TipoVeiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroVeiculoDto(
        @NotNull
        TipoVeiculo tipoVeiculo,
        @NotBlank
        String nome,
        @NotBlank
        String chassi,
        @NotNull
        Integer ano,
        @NotBlank
        String cor,
        @NotNull
        Float peso
){
}
