package by.testtask.bootcamp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "lastname", length = 40)
    private String lastName;
    @Column(name = "firstname",  length = 20)
    private String firstName;
    @Column(length = 40)
    private String patronymic;
    @Column(unique = true, updatable = false)
    private String email;

//    @Column(length = 100)
//    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role")
    private RoleEntity roleEntity;

    public UserEntity(String lastName, String firstName, String patronymic,
                      String email, RoleEntity roleEntity) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.roleEntity = roleEntity;
    }
}
