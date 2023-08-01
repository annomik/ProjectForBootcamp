package by.testtask.bootcamp.services;

import by.testtask.bootcamp.core.dto.PageDTO;
import by.testtask.bootcamp.core.dto.UserCreateDTO;
import by.testtask.bootcamp.core.dto.UserDTO;
import by.testtask.bootcamp.core.enums.ErrorCode;
import by.testtask.bootcamp.core.exceptions.ConversionTypeException;
import by.testtask.bootcamp.core.exceptions.InputSingleDataException;
import by.testtask.bootcamp.entities.UserEntity;
import by.testtask.bootcamp.repositories.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Validated
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ConversionService conversionService;
    private static final Logger logger = LogManager.getLogger(UserService.class);

    public void createUser(@NotNull @Valid UserCreateDTO userCreateDTO) {
        String email = userCreateDTO.getEmail();
        if (userRepository.findByEmail(email) != null){
            throw  new InputSingleDataException("User with this email already exists.", ErrorCode.ERROR);
        }
        if(!conversionService.canConvert(UserCreateDTO.class, UserEntity.class)) {
            throw new ConversionTypeException("Failed to convert", ErrorCode.ERROR);
        }
        UserEntity userEntity = conversionService.convert(userCreateDTO, UserEntity.class);
        userRepository.save(userEntity);
        logger.info("New user has been created: " + userCreateDTO);
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> allEntities = userRepository.findAll();
        if(!conversionService.canConvert(UserCreateDTO.class, UserEntity.class)) {
            throw new ConversionTypeException("Failed to convert", ErrorCode.ERROR);
        }
        List<UserDTO> collect = allEntities.stream()
                .map(s -> conversionService.convert(s, UserDTO.class))
                .sorted(Comparator.comparing(o -> o.getEmail()))
                .collect(Collectors.toList());
        logger.info("List of users received");
        return collect;
        }

    public PageDTO<UserDTO> getPage(int numberOfPage, int size) {
        Pageable pageable = PageRequest.of(numberOfPage, size);
        Page<UserEntity> allEntity = userRepository.findAll(pageable);

        if(!conversionService.canConvert(UserCreateDTO.class, UserEntity.class)) {
            throw new ConversionTypeException("Failed to convert", ErrorCode.ERROR);
        }
        List<UserDTO> content = allEntity.getContent().stream()
                .map(s -> conversionService.convert(s, UserDTO.class))
                .sorted(Comparator.comparing(o -> o.getEmail()))
                .collect(Collectors.toList());
        logger.info("Page(s) of users received");

        return new PageDTO<>(allEntity.getNumber(),
                allEntity.getSize(),
                allEntity.getTotalPages(),
                allEntity.getTotalElements(),
                allEntity.isFirst(),
                allEntity.getNumberOfElements(),
                allEntity.isLast(),
                content);
    }
}
