package de.ait.demo.controller;

import de.ait.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return List.of(
                new User("Jack", "jack@mail.com"),
                new User("Anna", "anna@mail.com")
        );
    }

}
