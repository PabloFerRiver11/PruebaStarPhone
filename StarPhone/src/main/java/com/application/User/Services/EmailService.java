package com.application.User.Services;

import com.application.User.Entities.User;

public interface EmailService {
    boolean sendEmail(User usu, String asunto, String password, String imagen);
}
