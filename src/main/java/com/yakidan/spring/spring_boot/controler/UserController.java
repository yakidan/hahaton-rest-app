package com.yakidan.spring.spring_boot.controler;

import com.yakidan.spring.spring_boot.entity.User;
import com.yakidan.spring.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showAllUser()
    {
        return userService.getAllUser();
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addNewUsers(@RequestBody User user) {
        return userService.addNewUser(user);
    }


    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
