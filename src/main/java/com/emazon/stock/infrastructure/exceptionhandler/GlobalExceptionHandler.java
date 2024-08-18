package com.emazon.stock.infrastructure.exceptionhandler;

import com.emazon.stock.infrastructure.exception.CategoryAlreadyExistException;
import com.emazon.stock.infrastructure.exception.CategoryDescriptionMissingException;
import com.emazon.stock.infrastructure.exception.CategoryDescriptionTooLongException;
import com.emazon.stock.infrastructure.exception.CategoryNameTooLongException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String MESSAGE = "message";

    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistsException(
            CategoryAlreadyExistException categoryAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(CategoryDescriptionMissingException.class)
    public ResponseEntity<Map<String, String>> handleCategoryDescriptionMissing(
            CategoryDescriptionMissingException categoryDescriptionMissingException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_DESCRIPTION_MISSING.getMessage()));
    }

    @ExceptionHandler(CategoryDescriptionTooLongException.class)
    public ResponseEntity<Map<String, String>> handleCategoryDescriptionLong(
            CategoryDescriptionTooLongException categoryDescriptionTooLongException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_DESCRIPTION_TOO_LONG.getMessage()));
    }

    @ExceptionHandler(CategoryNameTooLongException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNameLong(
            CategoryNameTooLongException categoryNameTooLongException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_NAME_TOO_LONG.getMessage()));
    }










}