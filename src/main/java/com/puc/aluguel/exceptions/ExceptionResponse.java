package com.puc.aluguel.exceptions;

import java.time.LocalDate;

public class ExceptionResponse {

    private LocalDate timestamp;
    private String message;
    private String details;

    public ExceptionResponse(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
