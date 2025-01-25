package com.kishor_gorantala.currency_exchange_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomizedExceptionEntity> handleGenericException(Exception ex, WebRequest request) throws Exception {

        CustomizedExceptionEntity exceptionEntity = new CustomizedExceptionEntity(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<CustomizedExceptionEntity>(exceptionEntity, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<CustomizedExceptionEntity> HandleResourceNotFoundException(Exception ex, WebRequest request) throws Exception {

        CustomizedExceptionEntity exceptionEntity = new CustomizedExceptionEntity(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return  new ResponseEntity<CustomizedExceptionEntity>(exceptionEntity,HttpStatus.NOT_FOUND);

    }


    }
