package com.br4.ms.contacorrente.persistencia.entidades;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.money.BigMoney;

import com.br4.ms.contacorrente.persistencia.Entidade;
;

@Entity
@Table(name = "SaldoConta")
public class SaldoConta extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6398348383903780169L;
	
	
	@Id
	@ManyToOne
	private ContaCorrente conta;
	
	@Id
	private Moeda moeda;

	private BigMoney saldo;
	

	@Override
	public int hashCode() {
		return Objects.hash(conta, moeda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaldoConta other = (SaldoConta) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(moeda, other.moeda);
	}

	public ContaCorrente getConta() {
		return conta;
	}

	public void setConta(ContaCorrente conta) {
		this.conta = conta;
	}

	public BigMoney getSaldo() {
		return saldo;
	}

	public void setSaldo(BigMoney saldo) {
		this.saldo = saldo;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
	
}
