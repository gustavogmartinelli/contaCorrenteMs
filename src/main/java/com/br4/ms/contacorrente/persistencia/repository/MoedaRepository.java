package com.br4.ms.contacorrente.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br4.ms.contacorrente.persistencia.entidades.Moeda;

@Repository
public interface MoedaRepository extends JpaRepository<Moeda, Integer> {

}
