package com.botelho.loester.api_calculadora.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResposta> tratarIllegalArgumentException(IllegalArgumentException ex) {
        ErroResposta erro = new ErroResposta(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResposta> tratarHttpMessageNotReadableException(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        ErroResposta erro = new ErroResposta(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "Erro de desserialização no JSON: verifique se os tipos dos campos e valores de Enums estão corretos. [SOMAR, SUBTRAIR, MULTIPLICAR, DIVIDIR]"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    
}