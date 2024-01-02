package com.application.User.Services;

import com.application.User.Entities.Role;
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
        if (user.getRol() == Rol.ADMIN) {
            user.setActivate(true);

        }
        else {
            user.setActivate(false);
        }

        user.setActivateCode(UUID.randomUUID().toString().substring(0, 8));
        user.setRegisterDate(LocalDate.now());

        try {
            userRepository.save(user);
            emailService.sendActivateEmail(user);
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
            throw new UsernameNotFoundException("Usuario no presente con nombre: " + username);
        } else {
            return user.get();
        }

    }

    public boolean activateUserCode(String email, String registerCode) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() && user.get().getActivateCode().equals(registerCode)) {
            user.get().setActivate(true);
            user.get().addRole(Role.CUSTOMER);
            userRepository.save(user.get());
            return true;

        } else {
            return false;
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

    public boolean isActivated(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get().getActivate();
        } else {
            return false;
        }
    }

    public  int count() {
        return (int) userRepository.count();
    }



}
