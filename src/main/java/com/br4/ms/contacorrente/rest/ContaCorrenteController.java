package com.br4.ms.contacorrente.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br4.ms.contacorrente.operacao.Resposta;
import com.br4.ms.contacorrente.persistencia.repository.ContaCorrenteRepository;

@RestController
public class ContaCorrenteController {
	
	@Autowired
	private ContaCorrenteRepository repository;
	
	@RequestMapping(value = "/credito", method = RequestMethod.POST, 
		    consumes = "application/json", produces = "application/json")
	public Resposta realizaCredito(@RequestBody Resposta conta) {
		
		return conta;
	}

	
	@RequestMapping(value = "/debito", method = RequestMethod.POST, 
		    consumes = "application/json", produces = "application/json")
	public Resposta realizarDebito(@RequestBody Resposta conta) {
		conta.setConteudo("debito");
		return conta;
	}
	
	@RequestMapping(value = "/extrato", method = RequestMethod.POST, 
		    consumes = "application/json", produces = "application/json")
	public Resposta geraExtrato(@RequestBody Resposta conta) {
		conta.setConteudo("extrato");
		return conta;
	}
	
	@RequestMapping(value = "/saldo", method = RequestMethod.POST, 
		    consumes = "application/json", produces = "application/json")
	public Resposta geraSaldo(@RequestBody Resposta conta) {
		//repository.findByidContaAndMoeda(idConta, moeda)
		conta.setConteudo("extrato");
		return conta;
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.POST, 
			consumes = "application/json", produces = "application/json")
	public Resposta criarConta(@RequestBody Resposta conta) {
//		repository.save(entity)
		conta.setConteudo("conta criada");
		return conta;
	}
}
