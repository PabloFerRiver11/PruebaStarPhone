package com.application.User.Services;

import com.application.User.Entities.User;

public interface EmailService {
    boolean sendForgotPasswordEmail(User usu, String password, String imagen);

    boolean sendActivateEmail(User usu);
}
