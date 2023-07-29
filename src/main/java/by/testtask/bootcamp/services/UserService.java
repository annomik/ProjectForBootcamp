package by.testtask.bootcamp.services;

import by.testtask.bootcamp.models.User;
import by.testtask.bootcamp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;

        userRepository.save(user);
        return true;
    }


    public List<User> listOfUsers() {
        return userRepository.findAll();
    }

}
