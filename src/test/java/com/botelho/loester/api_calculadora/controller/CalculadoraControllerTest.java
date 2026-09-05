package com.botelho.loester.api_calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.botelho.loester.api_calculadora.dto.request.CalculadoraRequisicao;
import com.botelho.loester.api_calculadora.dto.response.CalculadoraResposta;
import com.botelho.loester.api_calculadora.enums.Operacoes;
import com.botelho.loester.api_calculadora.service.CalculadoraService;

@ExtendWith(MockitoExtension.class)
class CalculadoraControllerTest {

    @Mock
    private CalculadoraService calculadoraService;

    @InjectMocks
    private CalculadoraController calculadoraController;

    
    // -------------------------------------------------------------------------------------------------
    
    
    @ParameterizedTest
    @CsvSource({
        "10, 5, 15",
        "100, 50, 150",
        "0, 10, 10",
        "-10, 5, -5",
        "-10, -5, -15"
    })
    void deveSomar(int numero1, int numero2, int resultadoEsperado) {
        CalculadoraRequisicao request = new CalculadoraRequisicao(numero1, numero2, Operacoes.SOMAR);
        CalculadoraResposta respostaEsperada = new CalculadoraResposta(numero1, numero2, Operacoes.SOMAR, resultadoEsperado);

        when(calculadoraService.somar(request)).thenReturn(respostaEsperada);

        CalculadoraResposta resposta = calculadoraController.calculadoraSomar(request);

        assertEquals(numero1, resposta.getNumero1());
        assertEquals(numero2, resposta.getNumero2());
        assertEquals(Operacoes.SOMAR, resposta.getOperacao());
        assertEquals(resultadoEsperado, resposta.getResultado());

        verify(calculadoraService).somar(request);
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
    void deveSubtrair(int numero1, int numero2, int resultadoEsperado) {
        CalculadoraRequisicao request = new CalculadoraRequisicao(numero1, numero2, Operacoes.SUBTRAIR);
        CalculadoraResposta respostaEsperada = new CalculadoraResposta(numero1, numero2, Operacoes.SUBTRAIR, resultadoEsperado);

        when(calculadoraService.subtrair(request)).thenReturn(respostaEsperada);

        CalculadoraResposta resposta = calculadoraController.calculadoraSubtrair(request);

        assertEquals(numero1, resposta.getNumero1());
        assertEquals(numero2, resposta.getNumero2());
        assertEquals(Operacoes.SUBTRAIR, resposta.getOperacao());
        assertEquals(resultadoEsperado, resposta.getResultado());

        verify(calculadoraService).subtrair(request);
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
    void deveMultiplicar(int numero1, int numero2, int resultadoEsperado) {
        CalculadoraRequisicao request = new CalculadoraRequisicao(numero1, numero2, Operacoes.MULTIPLICAR);
        CalculadoraResposta respostaEsperada = new CalculadoraResposta(numero1, numero2, Operacoes.MULTIPLICAR, resultadoEsperado);

        when(calculadoraService.multiplicar(request)).thenReturn(respostaEsperada);

        CalculadoraResposta resposta = calculadoraController.calculadoraMultiplicar(request);

        assertEquals(numero1, resposta.getNumero1());
        assertEquals(numero2, resposta.getNumero2());
        assertEquals(Operacoes.MULTIPLICAR, resposta.getOperacao());
        assertEquals(resultadoEsperado, resposta.getResultado());

        verify(calculadoraService).multiplicar(request);
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
    void deveDividir(int numero1, int numero2, int resultadoEsperado) {
        CalculadoraRequisicao request = new CalculadoraRequisicao(numero1, numero2, Operacoes.DIVIDIR);
        CalculadoraResposta respostaEsperada = new CalculadoraResposta(numero1, numero2, Operacoes.DIVIDIR, resultadoEsperado);

        when(calculadoraService.dividir(request)).thenReturn(respostaEsperada);

        CalculadoraResposta resposta = calculadoraController.calculadoraDividir(request);

        assertEquals(numero1, resposta.getNumero1());
        assertEquals(numero2, resposta.getNumero2());
        assertEquals(Operacoes.DIVIDIR, resposta.getOperacao());
        assertEquals(resultadoEsperado, resposta.getResultado());

        verify(calculadoraService).dividir(request);
    }
    
    
    // -------------------------------------------------------------------------------------------------
    
    
    @Test
    void deveRetornarZeroAoDividirPorZero() {
        CalculadoraRequisicao request = new CalculadoraRequisicao(10, 0, Operacoes.DIVIDIR);
        CalculadoraResposta respostaEsperada = new CalculadoraResposta(10, 0, Operacoes.DIVIDIR, 0);

        when(calculadoraService.dividir(request)).thenReturn(respostaEsperada);

        CalculadoraResposta resposta = calculadoraController.calculadoraDividir(request);

        assertEquals(10, resposta.getNumero1());
        assertEquals(0, resposta.getNumero2());
        assertEquals(Operacoes.DIVIDIR, resposta.getOperacao());
        assertEquals(0, resposta.getResultado());

        verify(calculadoraService).dividir(request);
    }
    
    
    // -------------------------------------------------------------------------------------------------
    
    
}