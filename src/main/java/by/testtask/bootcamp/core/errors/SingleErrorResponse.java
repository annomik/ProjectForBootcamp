package by.testtask.bootcamp.core.errors;

import by.testtask.bootcamp.core.enums.ErrorCode;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SingleErrorResponse {

    private ErrorCode logref;
    private String message;
}
