package com.br4.ms.contacorrente.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br4.ms.contacorrente.operacao.Resposta;


@RestController
public class CreditoContaController{

	/**
	 * 
	 */

	@RequestMapping(value = "/credito", method = RequestMethod.POST, 
		    consumes = "application/json", produces = "application/json")
	public Resposta greeting(@RequestBody Resposta conta) {
		conta.setConteudo(conta.getConteudo() + "1");
		return conta;
	}

}
