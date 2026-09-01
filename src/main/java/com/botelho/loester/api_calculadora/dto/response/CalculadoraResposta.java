package com.botelho.loester.api_calculadora.dto.response;

import com.botelho.loester.api_calculadora.enums.Operacoes;

public class CalculadoraResposta {

	private int numero1;
	private int numero2;
	private Operacoes operacao;
	private int resultado;

	public CalculadoraResposta() {
	}

	public CalculadoraResposta(int numero1, int numero2, Operacoes operacao, int resultado) {
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.operacao = operacao;
		this.resultado = resultado;
	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	public Operacoes getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacoes operacao) {
		this.operacao = operacao;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "CalculadoraResposta [numero1=" + numero1 + 
				", numero2=" + numero2 + 
				", operacao=" + operacao
				+ ", resultado=" + resultado + 
				"]";
	}

}
