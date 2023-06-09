package com.acme.myshoes.platform.shared.exception;

import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;
import java.util.stream.Collectors;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceValidationException extends RuntimeException{


    public ResourceValidationException() {
    }

    public ResourceValidationException(String message) {
        super(message);
    }

    public ResourceValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceValidationException(String resourceName, String message){
        super(String.format("Not all constrains satisfied for %s: %s", resourceName, message));
    }

    //stream: permite realizar operaciones de manera secuencial.
    //map aplicara el lamda acada elemento de violations.
    public <T>ResourceValidationException(String resourceName, Set<ConstraintViolation<T>> violations){
        violations.stream().map(violation -> String.format("%s %s:",
                violation.getPropertyPath(), violation.getMessage())).collect(Collectors.joining(", "));

    }
}