package by.testtask.bootcamp.controllers;

import by.testtask.bootcamp.core.enums.ErrorCode;
import by.testtask.bootcamp.core.errors.SingleErrorResponse;
import by.testtask.bootcamp.core.exceptions.ConversionTypeException;
import by.testtask.bootcamp.core.exceptions.InputSingleDataException;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@NoArgsConstructor
@RestControllerAdvice
public class ExceptionGlobalHandler {

//    @ExceptionHandler(value = {NullPointerException.class})
//    public ResponseEntity<List<SingleErrorResponse>> handleNPE(){
//        List<SingleErrorResponse> errors = new ArrayList<>();
//        errors.add(new SingleErrorResponse("error", "Sorry, but NullPointerException :( "));
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(errors);
//    }

    @ExceptionHandler
    public ResponseEntity<List<SingleErrorResponse>> handle(InputSingleDataException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(List.of(new SingleErrorResponse(e.getErrorCode(), e.getMessage())));
    }

    @ExceptionHandler(value = {ConversionTypeException.class, Exception.class})
    public ResponseEntity<List<SingleErrorResponse>> handle(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(List.of(new SingleErrorResponse(ErrorCode.ERROR, e.getMessage())));
    }

 //   List<ErrorForSingleResponse> errors = new ArrayList<>();

//    @ExceptionHandler
//    public ResponseEntity<List<SingleErrorResponse>>handleSingleErrors(SingleErrorResponse e){
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(e.getErrors());
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<MultipleErrorResponseDTO>handleMultiErrors(MultipleErrorResponse e){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(new MultipleErrorResponseDTO(e.getLogref(), e.getErrors()));
//    }
//500
//    @ExceptionHandler  //(value = {IllegalAccessException.class})
//    public ResponseEntity<List<ErrorForSingleResponse>> handleAll(Throwable e) {
//        List<ErrorForSingleResponse> errors = new ArrayList<>();
//        errors.add(new ErrorForSingleResponse("error",
//                "Сервер не смог корректно обработать запрос. Пожалуйста обратитесь к администратору"));
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(errors);
//           }


}
