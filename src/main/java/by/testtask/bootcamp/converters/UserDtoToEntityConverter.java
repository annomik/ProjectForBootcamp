package by.testtask.bootcamp.converters;

import by.testtask.bootcamp.core.dto.UserCreateDTO;
import by.testtask.bootcamp.entities.RoleEntity;
import by.testtask.bootcamp.entities.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToEntityConverter implements Converter<UserCreateDTO, UserEntity> {
    @Override
    public UserEntity convert(UserCreateDTO userCreateDTO) {

        return new UserEntity(userCreateDTO.getLastName(),
                userCreateDTO.getFirstName(),
                userCreateDTO.getPatronymic(),
                userCreateDTO.getEmail(),
                new RoleEntity(userCreateDTO.getUserRole())
        );
    }

}
