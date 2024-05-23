package com.locadoraveiculos.api.repository;

import com.locadoraveiculos.api.model.Locacao;
import com.locadoraveiculos.api.model.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    List<Locacao> findByLocadora(Locadora locadora);
}
