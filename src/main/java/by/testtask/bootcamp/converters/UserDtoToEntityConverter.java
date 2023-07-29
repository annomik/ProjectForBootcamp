package by.testtask.bootcamp.converters;

import by.testtask.bootcamp.core.UserCreateDTO;
import by.testtask.bootcamp.core.UserDTO;
import by.testtask.bootcamp.models.RoleEntity;
import by.testtask.bootcamp.models.UserEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToEntityConverter implements Converter<UserCreateDTO, UserEntity> {
    @Override
    public UserEntity convert(UserCreateDTO userDTO) {

        return new UserEntity(userDTO.getLastName(),
                userDTO.getFirstName(),
                userDTO.getPatronymic(),
                userDTO.getEmail(),
                new RoleEntity(userDTO.getUserRole())
                );

    }

}
