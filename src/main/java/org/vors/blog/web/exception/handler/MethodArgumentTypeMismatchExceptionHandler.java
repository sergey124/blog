package org.vors.blog.web.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestControllerAdvice(basePackages = {"org.vors.blog.web"})
public class MethodArgumentTypeMismatchExceptionHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity methodArgumentTypeMismatchException() {
        return new ResponseEntity<>(NOT_FOUND);
    }
}