package com.houdaifa.stockmanagement.handlers;

import com.houdaifa.stockmanagement.exceptions.EntityNotFoundException;
import com.houdaifa.stockmanagement.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.InvalidClassException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest){
    final HttpStatus notFound=HttpStatus.NOT_FOUND;
    final ErrorDto errorDto= ErrorDto.builder()
            .code(exception.getErrorCodes())
            .httpCode(notFound.value())
            .message(exception.getMessage())
            .build();
    return new ResponseEntity<>(errorDto,notFound);

}
@ExceptionHandler(InvalidEntityException.class)
public ResponseEntity<ErrorDto>handleException(InvalidEntityException exception,WebRequest webRequest){
    final HttpStatus badRequest=HttpStatus.BAD_REQUEST;

    final ErrorDto errorDto=ErrorDto.builder()
            .code(exception.getErrorCodes())
            .httpCode(badRequest.value())
            .message(exception.getMessage())
            .errors(exception.getErrors())
            .build();
    return new ResponseEntity<>(errorDto,badRequest);
}




}
