package com.locadoraveiculos.api.dto;

import com.locadoraveiculos.api.model.Locacao;
import com.locadoraveiculos.api.model.Status;

import java.time.LocalDateTime;

public record LocacaoDto(
        Long id,
        LocalDateTime data,
        Long idLocatario,
        Long idVeiculo,
        Status status,
        String justificativaStatus
) {
    public LocacaoDto(Locacao locacao) {
        this(locacao.getId(), locacao.getData(), locacao.getLocatario(), locacao.getVeiculo(), locacao.getStatus(), locacao.getJustificativaStatus());
    }
}
