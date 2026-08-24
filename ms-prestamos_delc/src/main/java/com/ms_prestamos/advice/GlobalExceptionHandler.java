package com.ms_prestamos.advice;

import com.ms_prestamos.errors.ApiErrors;
import com.ms_prestamos.exception.BusinessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrors> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String mensajeUsuario = "ERROR DE INTEGRIDAD: EL ID DEL CLIENTE O EL TIPO DE PRÉSTAMO NO EXISTE EN EL SISTEMA.";

        // Si quieres inspeccionar el error de Oracle directamente en el mensaje
        if (ex.getMessage() != null && ex.getMessage().contains("FK_PRESTAMOS_CLIENTE_ID")) {
            mensajeUsuario = "NO SE PUEDE OTORGAR EL PRÉSTAMO. EL ID DE CLIENTE PROVISTO NO ESTÁ REGISTRADO.";
        }

        ApiErrors errores = new ApiErrors(
                mensajeUsuario,
                HttpStatus.BAD_REQUEST, // Código 400 Bad Request
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            BusinessException.NotExistException.class,
            BusinessException.LoanIdNotExistException.class
    })
    public ResponseEntity<ApiErrors> handleNotFoundExceptions(BusinessException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        System.out.println("ERROR 404 CAPTURADO: " + errores.getMensaje());
        return new ResponseEntity<>(errores, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({
            BusinessException.InvalidLoanAmount.class,
            BusinessException.InvalidPaymentAmount.class,
            BusinessException.PaymentExceedsRemainingBalance.class
    })
    public ResponseEntity<ApiErrors> handleBadRequestExceptions(BusinessException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        System.out.println("ERROR 400 CAPTURADO: " + errores.getMensaje());
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrors> handleGenericBusinessException(BusinessException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}