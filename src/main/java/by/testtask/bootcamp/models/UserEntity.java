package by.testtask.bootcamp.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "bootcamp", name = "user")
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
    @Column(unique = true, updatable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    //    @Column(length = 100)
//    private String password;

    public UserEntity(String lastName, String firstName, String patronymic, String email, RoleEntity roleEntity) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.roleEntity = roleEntity;
    }
}