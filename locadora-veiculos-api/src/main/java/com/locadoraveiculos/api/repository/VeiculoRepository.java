package com.locadoraveiculos.api.repository;

import com.locadoraveiculos.api.model.Locadora;
import com.locadoraveiculos.api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByLocadora(Locadora locadora);

}
