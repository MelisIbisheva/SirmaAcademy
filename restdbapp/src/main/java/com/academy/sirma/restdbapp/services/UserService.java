package com.academy.sirma.restdbapp.services;

import com.academy.sirma.restdbapp.models.User;
import com.academy.sirma.restdbapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user){
        // TODO add some validations rules
        // password encrypt
        userRepository.saveUser(user);
    }
}
