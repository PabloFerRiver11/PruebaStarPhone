package com.application.User.Services;

import com.application.User.Entities.User;

public interface EmailService {
    boolean sendActivateEmail(User usu, String asunto, String body);
}
