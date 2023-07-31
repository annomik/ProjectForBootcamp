package by.testtask.bootcamp.core.exceptions;

import by.testtask.bootcamp.core.enums.ErrorCode;
import lombok.Getter;

@Getter
public class InputSingleDataException extends IllegalArgumentException{
    private ErrorCode errorCode;

    public InputSingleDataException(String s, ErrorCode errorCode) {
        super(s);
        this.errorCode = errorCode;
    }
}
