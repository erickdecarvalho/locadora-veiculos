package com.locadoraveiculos.api.repository;

import com.locadoraveiculos.api.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
