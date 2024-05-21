package com.locadoraveiculos.api.service;

import com.locadoraveiculos.api.dto.CadastroLocadoraDto;
import com.locadoraveiculos.api.exception.ValidacaoException;
import com.locadoraveiculos.api.model.Locadora;
import com.locadoraveiculos.api.repository.LocadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocadoraService {

    @Autowired
    private LocadoraRepository locadoraRepository;

    public Locadora cadastrar(CadastroLocadoraDto dto) {
        boolean jaCadastrado = locadoraRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        if (jaCadastrado) {
            throw new ValidacaoException("Dados já existentes para outra locadora!");
        }

        return locadoraRepository.save(new Locadora(dto));
    }
}
