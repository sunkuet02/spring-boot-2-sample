package com.sunkuet02.springboot2.controllers.exception;

import com.sunkuet02.springboot2.dto.response.ApiResponse;
import com.sunkuet02.springboot2.dto.response.Metadata;
import org.apache.log4j.Logger;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger log = Logger.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleControllerException(Exception ex, WebRequest req) {
        String errorMsg = ex.getMessage();
        ex.printStackTrace();
        Metadata metadata = new Metadata(HttpStatus.BAD_REQUEST.value(), errorMsg);

        return new ResponseEntity<>(new ApiResponse(metadata, null), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        ex.printStackTrace();
        String errorMsg = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        Metadata metadata = new Metadata(HttpStatus.BAD_REQUEST.value(), errorMsg);
        return new ResponseEntity(new ApiResponse(metadata, null), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ex.printStackTrace();
        String errorMsg = ex.getMessage();

        Metadata metadata = new Metadata(HttpStatus.NOT_ACCEPTABLE.value(), errorMsg);
        return new ResponseEntity(new ApiResponse(metadata, null), HttpStatus.NOT_ACCEPTABLE);
    }
}
