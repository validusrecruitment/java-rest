package com.validus.controller;

import com.validus.exception.GenericNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CatchAllExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception e, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GenericNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleResourceNotFound(Exception e, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), request.getDescription(true));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    class ErrorDetails {
        private Date timestamp;
        private String message;
        private String details;
    }


}
