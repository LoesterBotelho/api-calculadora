package com.botelho.loester.api_calculadora.service;

import org.springframework.stereotype.Service;

import com.botelho.loester.api_calculadora.dto.request.CalculadoraRequisicao;
import com.botelho.loester.api_calculadora.dto.response.CalculadoraResposta;
import com.botelho.loester.api_calculadora.enums.Operacoes;

@Service
public class CalculadoraService {

	public CalculadoraResposta somar(CalculadoraRequisicao request) {

		int resultadoSoma = request.getNumero1() + request.getNumero2();
		
		return new CalculadoraResposta(
				request.getNumero1(),
				request.getNumero2(),
				Operacoes.SOMAR,
				resultadoSoma
				);
	}

	public CalculadoraResposta subtrair(CalculadoraRequisicao request) {
		int resultadoSubtrair = request.getNumero1() - request.getNumero2();
		
		return new CalculadoraResposta(
				request.getNumero1(),
				request.getNumero2(),
				Operacoes.SUBTRAIR,
				resultadoSubtrair
				);
	}

	public CalculadoraResposta multiplicar(CalculadoraRequisicao request) {
		int resultadoMultiplicar = request.getNumero1() * request.getNumero2();
		
		return new CalculadoraResposta(
				request.getNumero1(),
				request.getNumero2(),
				Operacoes.MULTIPLICAR,
				resultadoMultiplicar
				);
	}

	public CalculadoraResposta dividir(CalculadoraRequisicao request) {
		int resultadoDividir = request.getNumero1() / request.getNumero2();
		
		return new CalculadoraResposta(
				request.getNumero1(),
				request.getNumero2(),
				Operacoes.DIVIDIR,
				resultadoDividir
				);
	}

}
