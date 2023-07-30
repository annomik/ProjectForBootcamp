package by.testtask.bootcamp.converters;

import by.testtask.bootcamp.core.UserDTO;
import by.testtask.bootcamp.entities.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDTO implements Converter<UserEntity, UserDTO> {
    @Override
    public UserDTO convert(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(),
                userEntity.getLastName(),
                userEntity.getFirstName(),
                userEntity.getPatronymic(),
                userEntity.getEmail(),
                userEntity.getRoleEntity().getRole()
        );
    }
}
