package by.testtask.bootcamp.repositories;

import by.testtask.bootcamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
