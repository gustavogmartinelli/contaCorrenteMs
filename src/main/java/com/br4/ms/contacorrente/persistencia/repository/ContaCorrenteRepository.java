
package com.br4.ms.contacorrente.persistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br4.ms.contacorrente.persistencia.entidades.ContaCorrente;
import com.br4.ms.contacorrente.persistencia.entidades.Moeda;
import com.br4.ms.contacorrente.persistencia.entidades.SaldoConta;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long>{

	
	public SaldoConta findByidContaAndMoeda(Long idConta, Moeda moeda);
	
}
