package com.br4.ms.contacorrente.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br4.ms.contacorrente.operacao.Resposta;


@RestController
public class CreditoContaController{

	/**
	 * 
	 */
	@RequestMapping("/credito")
	public Resposta credito() {
		Resposta conta  = new Resposta();
		conta.setConteudo("1");
		return conta;
	}

}
