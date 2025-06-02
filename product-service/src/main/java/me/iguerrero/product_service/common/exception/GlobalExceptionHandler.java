package me.iguerrero.product_service.common.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolationException;
import me.iguerrero.product_service.common.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleConstraintViolation(ConstraintViolationException ex) {
        return new ApiResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "HttpMessageNotReadableException. Probable cause: use of ',' instead of '.'.", LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleBadMethodArgument(MethodArgumentTypeMismatchException ex) {
        return new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Invalid parameter format.", LocalDateTime.now());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse handleProductNotFound(ProductNotFoundException ex) {
        return new ApiResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());
    }

}
