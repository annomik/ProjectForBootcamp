package by.testtask.bootcamp.models;

import by.testtask.bootcamp.models.enums.UserRole;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
