package com.br4.ms.contacorrente.persistencia.entidades;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
;

@Entity
@Table(name = "SaldoConta")
public class SaldoConta {

	@Id
	@OneToOne(optional = false)
	@ForeignKey(name = "idConta")
	private Long idConta;
	
}
