package by.testtask.bootcamp.core.dto;

import by.testtask.bootcamp.core.enums.UserRole;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String email;
    private UserRole userRole;

    public String getEmail() {
        return email;
    }
}
