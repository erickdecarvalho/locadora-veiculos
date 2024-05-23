package com.locadoraveiculos.api.dto;

import jakarta.validation.constraints.NotNull;

public record ReprovacaoLocacaoDto(@NotNull Long idLocacao, @NotNull String justificativa) {
}
