package com.ms_tarjetas.advice;

import com.ms_tarjetas.errors.ApiErrors;
import com.ms_tarjetas.exception.*;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected @Nullable ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Verbo HTTP no soportado por el método");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("MediaType no soportado");
        detalles.add(ex.getMessage());
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Variable de URL no encontrada");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Parámetro de peticion no encontrado");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final List<String> errors = new ArrayList<String>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        ApiErrors errores = new ApiErrors("Datos inválidos", errors, HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Formatos no coinciden");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Cuerpo de la peticion ilegible");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);

    }

    @ExceptionHandler(AccountAlreadyHasCardException.class)
    public ResponseEntity<Object> handleAccountAlreadyHasCardException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(409), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(409)).body(errores);
    }

    @ExceptionHandler(CardAlreadyAssignedToAccountException.class)
    public ResponseEntity<Object> handleCardAlreadyAssignedToAccountException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(409), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(409)).body(errores);
    }

    @ExceptionHandler(CardBlockedException.class)
    public ResponseEntity<Object> handleCardBlockedException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

    @ExceptionHandler(CardDisabledException.class)
    public ResponseEntity<Object> handleCardDisabledException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<Object> handleCardNotFoundException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

    @ExceptionHandler(InvalidCardNumberDigitsException.class)
    public ResponseEntity<Object> InvalidCardNumberDigitsException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

    @ExceptionHandler(AccountNotExistException.class)
    public ResponseEntity<Object> AccountNotExistException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(404), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errores);
    }

    @ExceptionHandler(CardTypeNotFoundException.class)
    public ResponseEntity<Object> CardTypeNotFoundException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(404), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errores);
    }

}
