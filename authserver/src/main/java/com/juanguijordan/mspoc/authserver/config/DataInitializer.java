package com.juanguijordan.mspoc.authserver.config;


import com.juanguijordan.mspoc.authserver.entity.User;
import com.juanguijordan.mspoc.authserver.repository.UserRepository;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        // admin / Testing1!
        userRepository.save(new User(null, "admin", "$2a$12$T1PCr4SMIHsOHC6ZORBkduUaS0MsY9SAcj9LmW8o/3uCA0Gd7wX3W", "ROLE_ADMIN,ROLE_USER"));
        // user1 / Testing2!
        userRepository.save(new User(null, "user1", "$2a$12$z7wIBKbCwL16kylIE4sJgOS5nSAS.ixmv9bLpWIoZGlTEohYz5O4u", "ROLE_USER"));
        System.out.println("User data initialized.");
    }
}