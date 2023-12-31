package by.testtask.bootcamp.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "bootcamp", name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "last_name", length = 40)
    private String lastName;
    @Column(name = "first_name", length = 20)
    private String firstName;
    @Column(length = 40)
    private String patronymic;
    @Column(unique = true, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    public UserEntity(String lastName, String firstName, String patronymic, String email, RoleEntity roleEntity) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.roleEntity = roleEntity;
    }
}