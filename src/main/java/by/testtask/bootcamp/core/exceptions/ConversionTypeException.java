package by.testtask.bootcamp.core.exceptions;

import by.testtask.bootcamp.core.enums.ErrorCode;
import lombok.Getter;

@Getter
public class ConversionTypeException extends RuntimeException {
    private ErrorCode errorCode;

    public ConversionTypeException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

