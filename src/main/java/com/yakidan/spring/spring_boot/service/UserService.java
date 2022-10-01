package com.yakidan.spring.spring_boot.service;

import com.yakidan.spring.spring_boot.entity.User;
import com.yakidan.spring.spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent())
            return optionalUser.get();
        throw new RuntimeException("User with id " + id + " Not found");
    }

    public User addNewUser(User user) {
        User newUser = new User(user.getNickname(),
                user.getFirstName(),
                user.getLastName(),
                passwordEncoder.encode(user.getPassword()));
        return repository.save(newUser);
    }

    public String deleteUserById(int id) {
        repository.deleteById(id);
        return "delete was success user with id =" + id;
    }
}
