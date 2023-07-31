package by.testtask.bootcamp.entities;

import by.testtask.bootcamp.core.enums.UserRole;
import lombok.*;
import jakarta.persistence.*;

//@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "bootcamp", name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name ="role")
    private UserRole role;

    public RoleEntity(UserRole role) {
        this.role = role;
    }
}
