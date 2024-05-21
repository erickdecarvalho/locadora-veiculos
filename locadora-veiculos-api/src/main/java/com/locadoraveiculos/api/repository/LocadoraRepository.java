package com.locadoraveiculos.api.repository;

import com.locadoraveiculos.api.model.Locadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocadoraRepository extends JpaRepository<Locadora, Long> {

    boolean existsByNomeOrTelefoneOrEmail(String nome, String telefone, String email);

}
