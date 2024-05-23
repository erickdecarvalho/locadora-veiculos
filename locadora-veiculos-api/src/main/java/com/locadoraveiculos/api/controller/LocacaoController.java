package com.locadoraveiculos.api.controller;

import com.locadoraveiculos.api.dto.AprovacaoLocacaoDto;
import com.locadoraveiculos.api.dto.ReprovacaoLocacaoDto;
import com.locadoraveiculos.api.dto.SolicitacaoLocacaoDto;
import com.locadoraveiculos.api.service.LocacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> solicitar(@RequestBody @Valid SolicitacaoLocacaoDto dto) {
        this.locacaoService.solicitar(dto);
        return ResponseEntity.ok("Locação solciitada com sucesso!");
    }

    @PutMapping("/aprovar")
    @Transactional
    public void aprovar(@RequestBody @Valid AprovacaoLocacaoDto dto) {
        this.locacaoService.aprovar(dto);
    }

    @PutMapping("/reprovar")
    @Transactional
    public void reprovar(@RequestBody @Valid ReprovacaoLocacaoDto dto) {
        this.locacaoService.reprovar(dto);
    }
}
