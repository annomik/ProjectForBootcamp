package by.testtask.bootcamp.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "bootcamp", name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "lastname", length = 40)
    private String lastName;
    @Column(name = "firstname", length = 20)
    private String firstName;
    @Column(length = 40)
    private String patronymic;
    @Column(unique = true, updatable = false)
    private String email;

//    @Column(length = 100)
//    private String password;

//    @Enumerated(EnumType.STRING)
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "role_id")

    @Enumerated(EnumType.STRING)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(schema = "bootcamp", name = "user_role",
            joinColumns=
            @JoinColumn(name="user_id"),
            inverseJoinColumns=
            @JoinColumn(name="role_id")
    )
    private RoleEntity roleEntity;

    public UserEntity(String lastName, String firstName, String patronymic, String email, RoleEntity roleEntity) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.roleEntity = roleEntity;
    }
}
