package com.botelho.loester.api_calculadora.dto.request;

import com.botelho.loester.api_calculadora.enums.Operacoes;

public class CalculadoraRequisicao {

	private int numero1;
	private int numero2;
	private Operacoes operacao;

	public CalculadoraRequisicao() {
	}

	public CalculadoraRequisicao(int numero1, int numero2, Operacoes operacao) {
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.operacao = operacao;
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

	@Override
	public String toString() {
		return "CalculadoraRequisicao [numero1=" + numero1 + 
				", numero2=" + numero2 + 
				", operacao=" + operacao + 
				"]";
	}



}
