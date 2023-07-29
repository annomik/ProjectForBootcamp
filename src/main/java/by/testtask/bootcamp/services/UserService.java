package by.testtask.bootcamp.services;

import by.testtask.bootcamp.core.UserCreateDTO;
import by.testtask.bootcamp.core.UserDTO;
import by.testtask.bootcamp.models.UserEntity;
import by.testtask.bootcamp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public boolean createUser(UserCreateDTO user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        UserEntity userEntity = conversionService.convert(user, UserEntity.class);
        userRepository.save(userEntity);
        return true;
    }

    public List<UserDTO> listOfUsers() {
        List<UserEntity> allEntities = userRepository.findAll();
        return allEntities.stream()
                .map(s -> conversionService.convert(allEntities, UserDTO.class))
                .collect(Collectors.toList());

             }

}
