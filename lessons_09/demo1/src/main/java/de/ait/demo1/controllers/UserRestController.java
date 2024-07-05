package de.ait.demo1.controllers;

import de.ait.demo1.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    private static List<User> serviceGetAllUser;

    static {
        serviceGetAllUser = List.of(
                new User("Jack", "jack@mail.com"),
                new User("Lena", "lena@mail.com"),
                new User("John", "john@mail.com")
        );
    }

    @GetMapping("/api/user")
    public List<User> getAllUser() {
        return serviceGetAllUser;
    }


}

