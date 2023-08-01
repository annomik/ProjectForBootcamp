package by.testtask.bootcamp.core.dto;

import by.testtask.bootcamp.UserRole;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String email;
    private UserRole userRole;

    public UserDTO(Long id, String lastName, String firstName, String patronymic, String email, UserRole userRole) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.userRole = userRole;
    }
}
