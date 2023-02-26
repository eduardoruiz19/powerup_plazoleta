package com.example.hexagonal.infrastructure.exceptionhandler;

import com.example.hexagonal.infrastructure.exception.NoDataFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception exception) {
        System.out.println("llega Excepcion:"+exception.getClass().toString());
        String txtMensaje = "";
        String txtException = "";
        switch (exception.getClass().toString()) {
            case "class com.example.hexagonal.infrastructure.exception.UserDocumentoIdentidadAlreadyExistException":
                txtMensaje = "Error";
                txtException = "Document Identity Already Exist ";

                break;

            case "class com.example.hexagonal.infrastructure.exception.UserMustBeOwnerException":
                txtMensaje = "Error";
                txtException = "User_id  Must Be Owner";
                //txtException = exception.getClass().toString();
                break;
            case "class com.example.hexagonal.infrastructure.exception.UserWithoutCredentialsException":
                txtMensaje = "Error";
                txtException = "User Without Credentials";
                //txtException = exception.getClass().toString();
                break;

            case "class com.example.hexagonal.infrastructure.exception.UserNotExistException":
                txtMensaje = "Error";
                txtException = "User Not Exist";
                //txtException = exception.getClass().toString();
                break;

            case "class org.springframework.dao.DataIntegrityViolationException":
                txtMensaje = "Error";
                txtException = "Key Field already Exist";
                //txtException = exception.getClass().toString();
                break;
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Collections.singletonMap(exception.getClass().toString(), exception.getMessage()));

        }

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(txtMensaje, txtException));


    }




    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Map<String, String>> handleExpiredJwtException(
            ExpiredJwtException expiredJwtException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("Token is Expired", "Please login again"));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

}