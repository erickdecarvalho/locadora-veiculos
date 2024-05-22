package com.locadoraveiculos.api.dto;

import com.locadoraveiculos.api.model.TipoVeiculo;
import com.locadoraveiculos.api.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDto(
    Long id,
     TipoVeiculo tipoVeiculo,
     String nome,
     String chassi,
     Integer ano,
     String cor,
     Float peso,
    Boolean alugado
) {
public VeiculoDto(Veiculo veiculo) {
    this(veiculo.getId(), veiculo.getTipo(), veiculo.getNome(), veiculo.getChassi(), veiculo.getAno(), veiculo.getCor(), veiculo.getPeso(), veiculo.getAlugado());
}

}
