package by.testtask.bootcamp.services;

import by.testtask.bootcamp.UserRepository;
import by.testtask.bootcamp.core.dto.UserCreateDTO;
import by.testtask.bootcamp.entities.UserEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserService.class)
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private ConversionService conversionService;
    @MockBean
    private UserRepository userRepository;
    @Test
    public void createUser() {
        UserCreateDTO userCreateDTO = new UserCreateDTO( );

      //  UserEntity convert = conversionService.convert(userCreateDTO, UserEntity.class);
        boolean isUserCreated = userService.createUser(userCreateDTO);

        Assert.assertTrue(isUserCreated);
    }
}