package by.testtask.bootcamp.core.errors;

import by.testtask.bootcamp.core.enums.ErrorCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class MultipleErrorResponse {

    private ErrorCode logref;
    private List<Error> errors = new ArrayList<>();

}
