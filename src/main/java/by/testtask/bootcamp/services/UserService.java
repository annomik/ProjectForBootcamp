package by.testtask.bootcamp.services;

import by.testtask.bootcamp.BootcampApplication;
import by.testtask.bootcamp.core.UserCreateDTO;
import by.testtask.bootcamp.core.UserDTO;
import by.testtask.bootcamp.entities.UserEntity;
import by.testtask.bootcamp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    private static final Logger logger = LogManager.getLogger(BootcampApplication.class);
    public boolean createUser(UserCreateDTO userCreateDTO) {
        String email = userCreateDTO.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        UserEntity userEntity = conversionService.convert(userCreateDTO, UserEntity.class);
        userRepository.save(userEntity);
        logger.info("New user has been created");
        return true;
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> allEntities = userRepository.findAll();
        return allEntities.stream()
                .map(s -> conversionService.convert(s, UserDTO.class))
                .collect(Collectors.toList());
        }

}
