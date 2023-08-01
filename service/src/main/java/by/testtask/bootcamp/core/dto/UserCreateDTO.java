package by.testtask.bootcamp.core.dto;

import by.testtask.bootcamp.UserRole;
import by.testtask.bootcamp.validator.api.ValidEmail;
import by.testtask.bootcamp.validator.api.ValidString;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {
    @ValidString
    private String lastName;
    @ValidString
    private String firstName;
    @ValidString
    private String patronymic;
    @ValidString
    @ValidEmail
    private String email;
    @NotNull(message = "This ROLE of users doesn't exist")
    private UserRole userRole;
}
