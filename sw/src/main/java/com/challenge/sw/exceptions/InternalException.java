package com.challenge.sw.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class InternalException extends RuntimeException {

    private final Throwable cause;

    private final String description;

    private final HttpStatus status;

    public InternalException(Throwable cause, String description, HttpStatus status) {
        this.cause = cause;
        this.description = description;
        this.status = status;
    }

    public InternalException(String description, HttpStatus status) {
        this.cause = null;
        this.description = description;
        this.status = status;
    }
}
