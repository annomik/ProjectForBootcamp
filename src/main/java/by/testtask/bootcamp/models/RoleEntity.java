package by.testtask.bootcamp.models;

import by.testtask.bootcamp.core.enums.UserRole;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
