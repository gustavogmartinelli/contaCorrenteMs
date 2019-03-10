package com.br4.ms.contacorrente.persistencia.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br4.ms.contacorrente.persistencia.Entidade;

@Entity
@Table(name="ContaCorrente")
public class ContaCorrente extends Entidade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1987166813611037636L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;

	@Override
	public int hashCode() {
		return Objects.hash(idConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		return Objects.equals(idConta, other.idConta);
	}
	
	

	
}
