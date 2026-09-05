package com.botelho.loester.api_calculadora.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.botelho.loester.api_calculadora.dto.request.CalculadoraRequisicao;
import com.botelho.loester.api_calculadora.dto.response.CalculadoraResposta;
import com.botelho.loester.api_calculadora.enums.Operacoes;

class CalculadoraServiceTest {

    private final CalculadoraService service = new CalculadoraService();

    
    // -------------------------------------------------------------------------------------------------
    
    
    @ParameterizedTest
    @CsvSource({
        "10, 5, 15",
        "100, 50, 150",
        "0, 10, 10",
        "-10, 5, -5",
        "-10, -5, -15"
    })
    void deveSomar(
            int numero1,
            int numero2,
            int resultadoEsperado) {

        CalculadoraRequisicao request =
                new CalculadoraRequisicao(
                        numero1,
                        numero2,
                        Operacoes.SOMAR
                );

        CalculadoraResposta resposta =
                service.somar(request);

        assertEquals(numero1, resposta.getNumero1());
        assertEquals(numero2, resposta.getNumero2());
        assertEquals(Operacoes.SOMAR, resposta.getOperacao());
        assertEquals(resultadoEsperado, resposta.getResultado());
    }


    // -------------------------------------------------------------------------------------------------
    

    @ParameterizedTest
    @CsvSource({
        "10, 5, 5",
        "100, 50, 50",
        "0, 10, -10",
        "-10, 5, -15",
        "-10, -5, -5"
    })
    void deveSubtrair(
            int numero1,
            int numero2,
            int resultadoEsperado) {

        CalculadoraRequisicao request =
                new CalculadoraRequisicao(
                        numero1,
                        numero2,
                        Operacoes.SUBTRAIR
                );

        CalculadoraResposta resposta =
                service.subtrair(request);

        assertEquals(numero1, resposta.getNumero1());
        assertEquals(numero2, resposta.getNumero2());
        assertEquals(Operacoes.SUBTRAIR, resposta.getOperacao());
        assertEquals(resultadoEsperado, resposta.getResultado());
    }


    // -------------------------------------------------------------------------------------------------
    
    
    @ParameterizedTest
    @CsvSource({
        "10, 5, 50",
        "100, 50, 5000",
        "0, 10, 0",
        "-10, 5, -50",
        "-10, -5, 50"
    })
    void deveMultiplicar(
            int numero1,
            int numero2,
            int resultadoEsperado) {

        CalculadoraRequisicao request =
                new CalculadoraRequisicao(
                        numero1,
                        numero2,
                        Operacoes.MULTIPLICAR
                );

        CalculadoraResposta resposta =
                service.multiplicar(request);

        assertEquals(numero1, resposta.getNumero1());
        assertEquals(numero2, resposta.getNumero2());
        assertEquals(Operacoes.MULTIPLICAR, resposta.getOperacao());
        assertEquals(resultadoEsperado, resposta.getResultado());
    }


    // -------------------------------------------------------------------------------------------------

    
    @ParameterizedTest
    @CsvSource({
        "10, 5, 2",
        "100, 10, 10",
        "50, 5, 10",
        "-10, 5, -2",
        "-10, -5, 2"
    })
    void deveDividir(
            int numero1,
            int numero2,
            int resultadoEsperado) {

        CalculadoraRequisicao request =
                new CalculadoraRequisicao(
                        numero1,
                        numero2,
                        Operacoes.DIVIDIR
                );

        CalculadoraResposta resposta =
                service.dividir(request);

        assertEquals(numero1, resposta.getNumero1());
        assertEquals(numero2, resposta.getNumero2());
        assertEquals(Operacoes.DIVIDIR, resposta.getOperacao());
        assertEquals(resultadoEsperado, resposta.getResultado());
    }
    
    
    // -------------------------------------------------------------------------------------------------
    
    
    @Test
    void deveRetornarZeroAoDividirPorZero() {
        CalculadoraRequisicao request = new CalculadoraRequisicao(10, 0, Operacoes.DIVIDIR);

        CalculadoraResposta resposta = service.dividir(request);

        assertEquals(10, resposta.getNumero1());
        assertEquals(0, resposta.getNumero2());
        assertEquals(Operacoes.DIVIDIR, resposta.getOperacao());
        assertEquals(0, resposta.getResultado());
    }
    
    
    // -------------------------------------------------------------------------------------------------
    
    
}