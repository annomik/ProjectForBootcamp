package by.testtask.bootcamp.controllers;

import by.testtask.bootcamp.core.dto.PageDTO;
import by.testtask.bootcamp.core.dto.UserCreateDTO;
import by.testtask.bootcamp.core.dto.UserDTO;
import by.testtask.bootcamp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserCreateDTO user) {
        userService.createUser(user);
    }

    @GetMapping("/users")
    public ResponseEntity<PageDTO<UserDTO>> getPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") int numberOfPage,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getPage(numberOfPage, size));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}
