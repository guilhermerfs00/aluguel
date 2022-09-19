package com.puc.aluguel.exceptions.handler;

import com.puc.aluguel.exceptions.BusinesException;
import com.puc.aluguel.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinesException.class)
    public final ResponseEntity<ExceptionResponse> handleBusinesException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
