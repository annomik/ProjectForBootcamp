package by.testtask.bootcamp.web;

import by.testtask.bootcamp.core.dto.PageDTO;
import by.testtask.bootcamp.core.dto.UserCreateDTO;
import by.testtask.bootcamp.core.dto.UserDTO;
import by.testtask.bootcamp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    private final UserService userService;
    private static final String SORT_FIELD = "email";

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserCreateDTO userCreateDTO) {
        logger.info("Request : User[{}]", userCreateDTO);
        userService.createUser(userCreateDTO);
    }

    @GetMapping("/user")
    public ResponseEntity<PageDTO<UserDTO>> getPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size){
        logger.info("Requested : page number = {}", pageNumber);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getPage(pageNumber, size, SORT_FIELD ));
    }
}
