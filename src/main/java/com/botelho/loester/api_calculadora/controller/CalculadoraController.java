package com.botelho.loester.api_calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.botelho.loester.api_calculadora.dto.request.CalculadoraRequisicao;
import com.botelho.loester.api_calculadora.dto.response.CalculadoraResposta;
import com.botelho.loester.api_calculadora.service.CalculadoraService;

@RestController
public class CalculadoraController {

	@Autowired
	CalculadoraService calculadoraService;
	
	@PostMapping("/calculadora/somar")
	public CalculadoraResposta calculadoraSomar(@RequestBody CalculadoraRequisicao request) {
		return calculadoraService.somar(request);
	}
	
	@PostMapping("/calculadora/subtrair")
	public CalculadoraResposta calculadoraSubtrair(@RequestBody CalculadoraRequisicao request) {
		return calculadoraService.subtrair(request);
	}
	
	@PostMapping("/calculadora/multiplicar")
	public CalculadoraResposta calculadoraMultiplicar(@RequestBody CalculadoraRequisicao request) {
		return calculadoraService.multiplicar(request);
	}
	
	@PostMapping("/calculadora/dividir")
	public CalculadoraResposta calculadoraDividir(@RequestBody CalculadoraRequisicao request) {
		return calculadoraService.dividir(request);
	}	
}
