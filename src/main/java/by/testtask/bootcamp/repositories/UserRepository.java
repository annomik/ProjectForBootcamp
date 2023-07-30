package by.testtask.bootcamp.repositories;

import by.testtask.bootcamp.entities.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
