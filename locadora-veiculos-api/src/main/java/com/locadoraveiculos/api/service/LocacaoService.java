package com.locadoraveiculos.api.service;

import com.locadoraveiculos.api.dto.AprovacaoLocacaoDto;
import com.locadoraveiculos.api.dto.ReprovacaoLocacaoDto;
import com.locadoraveiculos.api.dto.SolicitacaoLocacaoDto;
import com.locadoraveiculos.api.model.Locacao;
import com.locadoraveiculos.api.model.Locatario;
import com.locadoraveiculos.api.model.Veiculo;
import com.locadoraveiculos.api.repository.LocacaoRepository;
import com.locadoraveiculos.api.repository.LocatarioRepository;
import com.locadoraveiculos.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private LocatarioRepository locatarioRepository;

    public void solicitar(SolicitacaoLocacaoDto dto) {
        Locatario locatario = locatarioRepository.getReferenceById(dto.idLocatario());
        Veiculo veiculo = veiculoRepository.getReferenceById(dto.idVeiculo());

        Locacao locacao = new Locacao(locatario, veiculo);
        locacaoRepository.save(locacao);
    }

    public void aprovar(AprovacaoLocacaoDto dto) {
        Locacao locacao = locacaoRepository.getReferenceById(dto.idLocacao());
        locacao.marcarComoAprovada();
    }

    public void reprovar(ReprovacaoLocacaoDto dto) {
        Locacao locacao = locacaoRepository.getReferenceById(dto.idLocacao());
        var justificativa = dto.justificativa();
        locacao.marcarComoReprovada(justificativa);
    }

}
