package by.testtask.bootcamp.core.errors;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Error {

    private String field;
    private String message;

}
