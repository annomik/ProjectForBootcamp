package by.testtask.bootcamp.core;

import by.testtask.bootcamp.core.enums.UserRole;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {
    private String lastName;
    private String firstName;
    private String patronymic;
   // @ValidEmail
    private String email;
    private UserRole userRole;
}
