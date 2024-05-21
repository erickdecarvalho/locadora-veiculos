package com.locadoraveiculos.api.controller;

import com.locadoraveiculos.api.dto.CadastroLocadoraDto;
import com.locadoraveiculos.api.dto.DadosDetalhamentoLocadora;
import com.locadoraveiculos.api.model.Locadora;
import com.locadoraveiculos.api.service.LocadoraService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {

    @Autowired
    private LocadoraService locadoraService;

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

}
