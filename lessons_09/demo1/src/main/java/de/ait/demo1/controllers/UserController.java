package de.ait.demo1.controllers;

import de.ait.demo1.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {

    private static List<User> serviceGetAllUser;

    static {
        serviceGetAllUser = List.of(
                new User("Jack", "jack@mail.com"),
                new User("Lena", "lena@mail.com"),
                new User("John", "john@mail.com")
        );
    }

    @GetMapping("/user")
    public String getAllUser(Model model) {
        model.addAttribute("users", serviceGetAllUser);
        model.addAttribute("column1", "Имя пользователя");
        model.addAttribute("column2", "Email пользователя");

        return "user_list_view";
    }


}

