package com.br4.ms.contacorrente.persistencia.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br4.ms.contacorrente.persistencia.Entidade;

@Entity
@Table(name="Moeda")
public class Moeda  extends Entidade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8500552044906748184L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	

}
