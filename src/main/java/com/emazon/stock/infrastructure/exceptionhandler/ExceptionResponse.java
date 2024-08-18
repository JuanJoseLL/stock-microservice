package com.emazon.stock.infrastructure.exceptionhandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ExceptionResponse {
    CATEGORY_ALREADY_EXISTS(1, "Category already exists", HttpStatus.BAD_REQUEST, LogLevel.INFO),
    CATEGORY_NAME_TOO_LONG(2, "Category name must been less than 50 characters long", HttpStatus.BAD_REQUEST, LogLevel.INFO),
    CATEGORY_DESCRIPTION_TOO_LONG(3, "Category description must been less than 90 characters long", HttpStatus.BAD_REQUEST, LogLevel.INFO),
    CATEGORY_DESCRIPTION_MISSING(4, "A Category must have a description", HttpStatus.BAD_REQUEST, LogLevel.INFO),;

    private final int code;
    private final String message;
    private final HttpStatus responseStatus;
    private final LogLevel logLevel;
}
