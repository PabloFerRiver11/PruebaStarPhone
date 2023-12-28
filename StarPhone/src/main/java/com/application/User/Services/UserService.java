package com.application.User.Services;

import com.application.User.Entities.Rol;
import com.application.User.Entities.User;
import com.application.User.Repositories.UserRepository;
import jakarta.transaction.Transactional;
<<<<<<< Updated upstream
import org.springframework.beans.factory.annotation.Autowired;
=======

import org.springframework.dao.DataIntegrityViolationException;
>>>>>>> Stashed changes
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    // private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

<<<<<<< Updated upstream

@Autowired
    public UserService(UserRepository userRepository) {
=======
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) { // Falta el EmailService
>>>>>>> Stashed changes
        this.userRepository = userRepository;
        // this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // user.setActivateCode(UUID.randomUUID().toString().substring(0, 5));
        user.setRol(Rol.Cliente);

        try {
            userRepository.save(user);
            // emailService.sendRegistrationEmail(user);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

    @Override
    @Transactional
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            return user.get();
        }
    }

    public User loadUserByEmail(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException(email);
        }
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
