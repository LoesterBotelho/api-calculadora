package com.botelho.loester.api_calculadora.enums;

public enum Operacoes {

    SOMAR("Somar"),
    SUBTRAIR("Subtrair"),
    MULTIPLICAR("Multiplicar"),
    DIVIDIR("Dividir");

    private final String descricao;

    Operacoes(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}