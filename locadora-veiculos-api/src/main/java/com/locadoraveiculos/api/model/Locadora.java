package com.locadoraveiculos.api.model;

import com.locadoraveiculos.api.dto.CadastroLocadoraDto;
import jakarta.persistence.*;

@Entity
@Table(name = "locadoras")
public class Locadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    public Locadora() {
    }

    public Locadora(CadastroLocadoraDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }


}
