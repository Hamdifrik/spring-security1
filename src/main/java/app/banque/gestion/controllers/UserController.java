package app.banque.gestion.controllers;

import app.banque.gestion.entities.User;
import app.banque.gestion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User processSignup(@RequestBody User user) {
        user.setRole("ROLE_ADMIN"); // Set the role to ADMIN for admin signup
        userService.saveUser(user);
        return user;
    }
}
