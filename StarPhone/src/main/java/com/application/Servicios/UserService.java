package com.application.Servicios;

import com.application.Clases.User;
import com.application.Repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository){
            this.userRepository = userRepository;
        }

        public Optional<User> loadUserByEmail(String email) {
            return userRepository.findByemail(email);
        }





}
