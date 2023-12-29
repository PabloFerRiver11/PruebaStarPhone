package com.application.User.Services;

import com.application.User.Entities.Rol;
import com.application.User.Entities.User;
import com.application.User.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository uRepository, EmailService eService, PasswordEncoder pEncoder) {

        this.userRepository = uRepository;
        this.emailService = eService;
        this.passwordEncoder = pEncoder;
    }

    public boolean registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActivate(false); // Por defecto el usuario no está activado
        user.setActivateCode(UUID.randomUUID().toString().substring(0, 8));
        user.setRol(Rol.Customer);
        user.setRegisterDate(LocalDate.now());

        try {
            userRepository.save(user);
            String asunto = "Código de Activación";
            String body = "Su código de activación es: " + user.getActivateCode();
            emailService.sendActivateEmail(user, asunto, body);
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }

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
