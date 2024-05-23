package com.locadoraveiculos.api.dto;

import jakarta.validation.constraints.NotNull;

public record AprovacaoLocacaoDto(@NotNull Long idLocacao) {
}
