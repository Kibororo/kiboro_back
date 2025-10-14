package com.kiboro.kiboro_back.domain.Exeptions;

import org.springframework.stereotype.Component;

import com.kiboro.kiboro_back.domain.enums.TechnicalExceptionEnum;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import static java.time.LocalDateTime.now;

@Getter
@Component
public class TechnicalException extends Exception {
    private final String title;
    private final String time;
    private final HttpStatus status;
    private final String message;
    private final Throwable cause;
    private final Map<String, String> bindings;

    public TechnicalException(TechnicalExceptionEnum exceptionEnum, Throwable cause, Map<String, String> bindings) {
        super();
        this.title = exceptionEnum.getTitle();
        this.time = now().toString();
        this.status = exceptionEnum.getStatus();
        this.message = exceptionEnum.getMessage();
        this.cause = cause;
        this.bindings = bindings;
    }

    public TechnicalException(TechnicalExceptionEnum exceptionEnum, Throwable cause) {
        super();
        this.title = exceptionEnum.getTitle();
        this.time = now().toString();
        this.status = exceptionEnum.getStatus();
        this.message = exceptionEnum.getMessage();
        this.cause = cause;
        this.bindings = Map.of();
    }

    public TechnicalException(TechnicalExceptionEnum exceptionEnum) {
        super();
        this.title = exceptionEnum.getTitle();
        this.time = now().toString();
        this.status = exceptionEnum.getStatus();
        this.message = exceptionEnum.getMessage();
        this.cause = super.getCause();
        this.bindings = Map.of();
    }

    public TechnicalException() {
        super();
        this.title = null;
        this.time = now().toString();
        this.status = null;
        this.message = super.getMessage();
        this.cause = super.getCause();
        this.bindings = Map.of();
    }
}