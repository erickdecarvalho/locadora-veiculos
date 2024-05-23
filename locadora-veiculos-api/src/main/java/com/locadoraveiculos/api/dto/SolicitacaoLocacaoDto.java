package com.locadoraveiculos.api.dto;

import jakarta.validation.constraints.NotNull;

public record SolicitacaoLocacaoDto(@NotNull Long idLocatario, @NotNull Long idVeiculo) {
}
