package com.locadoraveiculos.api.service;

import com.locadoraveiculos.api.dto.*;
import com.locadoraveiculos.api.exception.ValidacaoException;
import com.locadoraveiculos.api.model.Locadora;
import com.locadoraveiculos.api.repository.LocacaoRepository;
import com.locadoraveiculos.api.repository.LocadoraRepository;
import com.locadoraveiculos.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocadoraService {

    @Autowired
    private LocadoraRepository locadoraRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private LocacaoRepository locacaoRepository;

    public List<LocadoraDto> listar() {
        return locadoraRepository.findAll().stream().map(LocadoraDto::new).toList();
    }

    public Locadora cadastrar(CadastroLocadoraDto dto) {
        boolean jaCadastrado = locadoraRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        if (jaCadastrado) {
            throw new ValidacaoException("Dados já existentes para outra locadora!");
        }

        return locadoraRepository.save(new Locadora(dto));
    }

    public Locadora atualizar(DadosAtualizacaoLocadora dto) {
        var locadora = locadoraRepository.getReferenceById(dto.id());

        if (dto.nome() != null) {
            locadora.atualizarNome(dto.nome());
        }
        if (dto.telefone() != null) {
            locadora.atualizarTelefone(dto.telefone());
        }
        if (dto.email() != null) {
            locadora.atualizarEmail(dto.email());
        }

        return locadora;
    }

    public Locadora detalhar(Long id) {
        var locadora = locadoraRepository.getReferenceById(id);

        return locadora;
    }

    public void excluir(Long id) {
        locadoraRepository.deleteById(id);
    }

    public List<VeiculoDto> listarVeiculosDaLocadora(Long id) {
        var locadora = locadoraRepository.getReferenceById(id);

        return veiculoRepository
                .findByLocadora(locadora)
                .stream()
                .map(VeiculoDto::new)
                .toList();
    }

    public List<LocacaoDto> listarLocacoessDaLocadora(Long id) {
        var locadora = locadoraRepository.getReferenceById(id);

        return locacaoRepository
                .findByLocadora(locadora)
                .stream()
                .map(LocacaoDto::new)
                .toList();
    }
}
