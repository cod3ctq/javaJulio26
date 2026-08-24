package com.ms_cuentas.advice;

import com.ms_cuentas.errors.ApiErrors;
import com.ms_cuentas.exception.AlreadyExistSameAccountTypeException;
import com.ms_cuentas.exception.BusinessException;
import com.ms_cuentas.exception.NotExistException;
import com.ms_cuentas.exception.UnderMinimumException;
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

//Manejador global de excepciones: Maneja la propagacion de cualquier excepcion lanzada
// en cualquier punto del sistema(de este servicio)
//Maneja excepciones genericas (que vienen de ResponseEntityExceptionHandler) @Override
//Maneja excepciones personalizadas (especificas del negocio) @ExceptionHandler

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

    //Se agregan las excepciones personalizadas al manejador global
    // usando @ExceptionHandler
    @ExceptionHandler(UnderMinimumException.class)
    public ResponseEntity<Object> handleUnderMinimumException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

    @ExceptionHandler(AlreadyExistSameAccountTypeException.class)
    public ResponseEntity<Object> handleAlreadyExistSameAccountTypeExceptionException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(409), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(409)).body(errores);
    }

    @ExceptionHandler(NotExistException.class)
    public ResponseEntity<Object> handleNotExistException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(204), LocalDateTime.now());
        System.out.println(errores);
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(errores);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> BusinessException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }

}
