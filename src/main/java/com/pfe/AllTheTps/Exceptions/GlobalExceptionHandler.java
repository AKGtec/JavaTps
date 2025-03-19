package com.pfe.AllTheTps.Exceptions;

import com.pfe.AllTheTps.DTOs.ApiError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiError> handleValidationException(ConstraintViolationException e) {
        List<String> errorMessages = new ArrayList<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errorMessages.add(violation.getMessage());
        }
        ApiError apiError = ApiError
                .builder()
                .code("C200")
                .message(errorMessages)
                .timestamp(LocalDate.now())
                .build();
        log.error("apiError {} ", apiError);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors =
                e.getBindingResult().getAllErrors().stream()
                        .map(error -> {
                            String fieldName = ((FieldError)
                                    error).getField();
                            String message = error.getDefaultMessage();
                            return fieldName + ": " + message;
                        })
                        .collect(Collectors.toList());
        ApiError apiError = ApiError
                .builder()
                .code("C200")
                .message(errors)
                .timestamp(LocalDate.now())
                .build();
        log.error("apiError {} ", apiError);
        return new ResponseEntity<>(apiError,
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String errorMessage = "Malformed JSON request. Please check the request payload.";
        ApiError apiError = ApiError
                .builder()
                .code("C400")
                .message(List.of(errorMessage))
                .timestamp(LocalDate.now())
                .build();
        log.error("apiError {} ", apiError);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}