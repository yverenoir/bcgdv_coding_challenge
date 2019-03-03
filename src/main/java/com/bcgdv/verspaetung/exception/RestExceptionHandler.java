package com.bcgdv.verspaetung.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public RestExceptionHandler() {
        super();
    }

    @ExceptionHandler({ StopNotFoundException.class })
    protected ResponseEntity<Object> handleStopNotFound(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Stop not found",
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ LineNotFoundException.class })
    protected ResponseEntity<Object> handleLineNotFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Line not found",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({IOException.class, DateTimeParseException.class})
    public ResponseEntity<Object> handleBadRequest(
      Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getLocalizedMessage(),
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}