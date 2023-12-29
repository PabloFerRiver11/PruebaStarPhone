package com.application.User.Services;

import com.application.User.Entities.User;

public interface EmailService {
    boolean sendForgotPasswordEmail(User usu, String asunto, String password, String imagen);

    boolean sendActivateEmail(User usu, String asunto, String body);
}
