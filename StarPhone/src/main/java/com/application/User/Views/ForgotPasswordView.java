package com.application.User.Views;

import com.application.User.Entities.User;
import com.application.User.Services.UserEmailService;
import com.application.User.Services.UserService;
import com.application.views.main.MainView;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

//TODO: @PermitAll + import jakarta.annotation.security.PermitAll;
@AnonymousAllowed
@PageTitle("Recuperar")
@Route(value = "/recuperarcredenciales")
public class ForgotPasswordView extends VerticalLayout {

    private EmailField email = new EmailField("E-mail");
    private User usu;
    private UserService userService;
    private final PasswordEncoder encoder;
    private UserEmailService userEmail;

    private Button cancel = new Button("Cancelar", event1 -> {
        Notification.show("Ha sido cancelada la recuperacion de contraseña");
        UI.getCurrent().navigate(MainView.class);
        // A real application would also save the updated person
        // using the application's backend
    });

    private Button crear = new Button("Mandar correo");

    public ForgotPasswordView(UserService uService, PasswordEncoder encoder, UserEmailService uEmail) {
        // TODO: Hacer vista de recuperar contraseña
        this.userService = uService;
        this.encoder = encoder;
        this.userEmail = uEmail;

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        crear.addClickListener(event2 -> {

            try {

                String password;
                // Obtengo usuario a partir de su correo
                try {
                    usu = this.userService.loadUserByEmail(email.getValue());
                } catch (UsernameNotFoundException dive) {
                    Notification.show("No se ha encontrado el usuario asociado a ese correo. Inténtelo de nuevo");
                    UI.getCurrent().navigate(ForgotPasswordView.class);

                }

                // Genero contraseña y se la asocio al usuario
                password = RecuperarContraseña(usu, email.getValue());
                usu.setPassword(this.encoder.encode(password));
                // Activo usuario si no lo esta
                if (!usu.getActivate()) {
                    usu.setActivate(true);
                }
                // Actualizo usuario
                userService.updateUser(usu);
                // Envio correo
                userEmail.sendForgotPasswordEmail(usu, password, null);
                UI.getCurrent().navigate(loginView.class);
                Notification.show("Ha sido enviado");

            } catch (UsernameNotFoundException dive) {
                Notification.show("Ha sido enviado");
                UI.getCurrent().navigate(loginView.class);
            }

        });

    }

    private Component createTitle() {
        return new H3("Recuperar contraseña");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Por favor, introduzca bien su email");
        formLayout.add(email);
        formLayout.setResponsiveSteps(
                new ResponsiveStep("1px", 1),
                new ResponsiveStep("600px", 2),
                new ResponsiveStep("700px", 3));
        return formLayout;

    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        crear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(crear);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    public String RecuperarContraseña(User usu, String email) {

        return crearcontraseña();

    }

    private String crearcontraseña() {

        String[] symbols = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "B", "c", "d", "E", "ñ" };
        int length = 10;
        Random random;

        try {
            random = SecureRandom.getInstanceStrong();
            StringBuilder ab = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int indexRandom = random.nextInt(symbols.length);
                ab.append(symbols[indexRandom]);
            }

            String password = ab.toString();

            return password;

        } catch (NoSuchAlgorithmException e) {

        }
        return null;

    }

}
