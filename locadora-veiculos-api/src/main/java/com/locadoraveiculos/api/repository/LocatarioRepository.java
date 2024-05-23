package com.locadoraveiculos.api.repository;

import com.locadoraveiculos.api.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocatarioRepository extends JpaRepository<Locatario, Long> {
}
