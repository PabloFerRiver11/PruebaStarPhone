package com.application.User.Security;

import com.application.User.Views.registerlogin.loginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(new AntPathRequestMatcher("/images/*.*"),
                        new AntPathRequestMatcher("/line-awesome/**/*.svg"),
                        new AntPathRequestMatcher("/logout"))
                .permitAll());

        super.configure(http);
        setLoginView(http, loginView.class);

        http.logout(logout -> logout
                .logoutUrl("/logout") // especifica el URL para cerrar la sesión
                .logoutSuccessUrl("/login") // especifica a qué URL redirigir después de cerrar la sesión
                .invalidateHttpSession(true)); // invalida la sesión
    }

}