package com.br4.ms.contacorrente.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.BigMoney;
import org.joda.time.DateTime;

import com.br4.ms.contacorrente.persistencia.Entidade;

@Entity
@Table(name = "Lancamento")
public class Lancamento  extends Entidade{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2993171372776741808L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLancamento;
	
	@Columns(columns = {@Column(name = "AMOUNT"), @Column(name = "CURRENCY")})
	@Type(type="com.br4.ms.contacorrente.persistencia.userType.MoneyUserType")
	private BigMoney value; 
	
	@Column(name="startTime")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime data;
	
	@ManyToOne
	private ContaCorrente conta;
	
	@ManyToOne
	private Moeda moeda;

	public Long getIdLancamento() {
		return idLancamento;
	}

	public void setIdLancamento(Long idLancamento) {
		this.idLancamento = idLancamento;
	}

	public BigMoney getValue() {
		return value;
	}

	public void setValue(BigMoney value) {
		this.value = value;
	}

	public DateTime getData() {
		return data;
	}

	public void setData(DateTime data) {
		this.data = data;
	}

	public ContaCorrente getConta() {
		return conta;
	}

	public void setConta(ContaCorrente conta) {
		this.conta = conta;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
	
}
