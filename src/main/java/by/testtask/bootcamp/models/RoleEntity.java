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
@Table(schema = "bootcamp", name = "role")
public class RoleEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    @Enumerated(EnumType.STRING)
   // @Column(name = "role")
    private UserRole role;
}
