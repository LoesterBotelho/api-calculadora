package com.botelho.loester.api_calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.botelho.loester.api_calculadora.dto.request.CalculadoraRequisicao;
import com.botelho.loester.api_calculadora.dto.response.CalculadoraResposta;
import com.botelho.loester.api_calculadora.service.CalculadoraService;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	// deve ser sempre private final
	private final CalculadoraService calculadoraService;

	// melhor para testes junit 6 e mockito
	// maneira correta de fazer	
	// após a versão 3 do spring é opcional @Autowired
	@Autowired
	public CalculadoraController(CalculadoraService calculadoraService) {
		this.calculadoraService = calculadoraService;
	}

	@PostMapping("/somar")
	public CalculadoraResposta calculadoraSomar(@RequestBody CalculadoraRequisicao request) {
		return calculadoraService.somar(request);
	}

	@PostMapping("/subtrair")
	public CalculadoraResposta calculadoraSubtrair(@RequestBody CalculadoraRequisicao request) {
		return calculadoraService.subtrair(request);
	}

	@PostMapping("/multiplicar")
	public CalculadoraResposta calculadoraMultiplicar(@RequestBody CalculadoraRequisicao request) {
		return calculadoraService.multiplicar(request);
	}

	@PostMapping("/dividir")
	public CalculadoraResposta calculadoraDividir(@RequestBody CalculadoraRequisicao request) {
		return calculadoraService.dividir(request);
	}
}
