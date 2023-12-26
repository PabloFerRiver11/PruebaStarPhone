package com.application.User.Views.registrologin;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

import com.application.User.Entities.User;
import com.application.User.Repositories.UserRepository;
import com.application.User.Security.SecurityConfiguration;

import com.application.User.Services.UserService;
import com.application.views.main.MainView;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@PageTitle("Recuperar")
@Route(value = "Recuperar")
public class ForgotPasswordView extends VerticalLayout {

    private EmailField email = new EmailField("E-mail");
    private User usu;
    private Binder<User> binder = new Binder(User.class);
    private UserRepository usuariorepository;
    private UserService usuarioservice;
    private SecurityConfiguration security;
    private PasswordEncoder encoder;
    //static UserEmailService UserEmail;

    private Button cancelar = new Button("Cancelar", event1 -> {
        Notification.show("Ha sido cancelada la recuperacion de contraseña");
        UI.getCurrent().navigate(MainView.class);
        // A real application would also save the updated person
        // using the application's backend
    });

    private Button crear = new Button("Mandar correo");



    public ForgotPasswordView(UserService usuarioservice, PasswordEncoder encoder/*UserEmailService UserEmail*/){

        this.usuarioservice = usuarioservice;
        this.encoder = encoder;
       // this.UserEmail = UserEmail;

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        crear.addClickListener(event2 -> {

            try {

                String password;
                String asunto = "Cambio de contraseña, aqui tiene su nueva contraseña";
                usu = this.usuarioservice.loadUserByEmail(email.getValue());
                password = RecuperarContraseña(usu,email.getValue());
                usu.setPassword(encoder.encode(password));
                if(!usu.getActivate())
                {
                    usu.setActivate(true);
                }
                usuarioservice.updateUser(usu);
                //UserEmail.sendEmail(email.getValue(),asunto,password,null);
                UI.getCurrent().navigate(login.class);
                Notification.show("Ha sido enviado");

            } catch (UsernameNotFoundException dive) {
                Notification.show("Ha sido enviado");
                UI.getCurrent().navigate(login.class);
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
        buttonLayout.add(cancelar);
        return buttonLayout;
    }


    public String RecuperarContraseña(User usu, String email) {

        return crearcontraseña();

    }
    private String crearcontraseña() {

        String[] symbols = {"0","1","2","3","4","5","6","7","8","9","a","B","c","d","E","ñ"};
        int length = 10;
        Random random;

        try {
            random = SecureRandom.getInstanceStrong();
            StringBuilder ab = new StringBuilder(length);
            for(int i = 0; i < length; i++)
            {
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
