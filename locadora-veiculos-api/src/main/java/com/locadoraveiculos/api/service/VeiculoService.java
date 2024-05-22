package com.locadoraveiculos.api.service;

import com.locadoraveiculos.api.dto.CadastroVeiculoDto;
import com.locadoraveiculos.api.model.Locadora;
import com.locadoraveiculos.api.model.Veiculo;
import com.locadoraveiculos.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void cadastrarVeiculo(Locadora locadora, CadastroVeiculoDto dto) {
        veiculoRepository.save(new Veiculo(dto, locadora));
    }

}
