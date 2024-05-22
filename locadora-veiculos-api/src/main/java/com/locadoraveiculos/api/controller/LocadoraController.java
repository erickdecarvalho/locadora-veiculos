package com.locadoraveiculos.api.controller;

import com.locadoraveiculos.api.dto.CadastroLocadoraDto;
import com.locadoraveiculos.api.dto.DadosAtualizacaoLocadora;
import com.locadoraveiculos.api.dto.DadosDetalhamentoLocadora;
import com.locadoraveiculos.api.dto.LocadoraDto;
import com.locadoraveiculos.api.model.Locadora;
import com.locadoraveiculos.api.service.LocadoraService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {

    @Autowired
    private LocadoraService locadoraService;

    @GetMapping
    public ResponseEntity<List<LocadoraDto>> listar() {
        List<LocadoraDto> locadoras = locadoraService.listar();

        return ResponseEntity.ok(locadoras);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroLocadoraDto dto, UriComponentsBuilder uriBuilder) {
        try {
            Locadora locadora = locadoraService.cadastrar(dto);

            System.out.println(locadora.getId());
            var uri = uriBuilder.path("/locadoras/{id}").buildAndExpand(locadora.getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosDetalhamentoLocadora(locadora));
        } catch (ValidationException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLocadora dto) {
        var locadora = locadoraService.atualizar(dto);

        return ResponseEntity.ok(new DadosDetalhamentoLocadora(locadora));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var locadora = locadoraService.detalhar(id);

        return ResponseEntity.ok(new DadosDetalhamentoLocadora(locadora));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        locadoraService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
