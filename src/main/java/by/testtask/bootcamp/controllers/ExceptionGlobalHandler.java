package by.testtask.bootcamp.controllers;

import by.testtask.bootcamp.core.enums.ErrorCode;
import by.testtask.bootcamp.core.errors.Error;
import by.testtask.bootcamp.core.errors.MultipleErrorResponse;
import by.testtask.bootcamp.core.errors.SingleErrorResponse;
import by.testtask.bootcamp.core.exceptions.ConversionTypeException;
import by.testtask.bootcamp.core.exceptions.InputSingleDataException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RestControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<List<SingleErrorResponse>> handleNPE(){
        List<SingleErrorResponse> errors = new ArrayList<>();
        errors.add(new SingleErrorResponse(ErrorCode.ERROR, "Sorry, but NullPointerException :( "));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler
    public ResponseEntity<List<SingleErrorResponse>> handleInputSingleDataException(InputSingleDataException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(List.of(new SingleErrorResponse(e.getErrorCode(), e.getMessage())));
    }

    @ExceptionHandler(value = {ConversionTypeException.class, Exception.class})
    public ResponseEntity<List<SingleErrorResponse>> handleConversionTypeException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new SingleErrorResponse(ErrorCode.ERROR, e.getMessage())));
    }

    @ExceptionHandler
    public ResponseEntity<MultipleErrorResponse> handleMultiErrors(MethodArgumentNotValidException e) {
        List<Error> errorList = e.getBindingResult().getAllErrors()
                .stream().map(error -> new Error(((FieldError) error).getField(), error.getDefaultMessage())).toList();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new MultipleErrorResponse(ErrorCode.STRUCTURED_ERROR, errorList));
    }

    @ExceptionHandler
    public ResponseEntity<MultipleErrorResponse> handle(ConstraintViolationException e) {
        List<Error> localErrors = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            String name = null;
            for (Path.Node node : constraintViolation.getPropertyPath()) {
                name = node.getName();
            }
            localErrors.add(new Error(name, constraintViolation.getMessage()));
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new MultipleErrorResponse(ErrorCode.STRUCTURED_ERROR, localErrors));
    }

    @ExceptionHandler
    public ResponseEntity<List<SingleErrorResponse>> handle(IllegalArgumentException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(List.of(new SingleErrorResponse(ErrorCode.ERROR, e.getMessage())));
    }
}
