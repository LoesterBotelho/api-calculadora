package com.botelho.loester.api_calculadora.enums;

public enum Operacoes {

    SOMAR("SOMAR"),
    SUBTRAIR("SUBTRAIR"),
    MULTIPLICAR("MULTIPLICAR"),
    DIVIDIR("DIVIDIR");

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