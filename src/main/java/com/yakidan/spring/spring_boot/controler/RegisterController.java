package com.yakidan.spring.spring_boot.controler;

import com.yakidan.spring.spring_boot.entity.User;
import com.yakidan.spring.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User addNewUsers(@RequestBody User user) {
        return userService.addNewUser(user);
    }

}
