package com.botelho.loester.api_calculadora.exception;

import java.time.LocalDateTime;

public record ErroResposta(
        LocalDateTime timestamp,
        int status,
        String error,
        String message
) {}