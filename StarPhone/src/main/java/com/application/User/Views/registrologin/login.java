package com.application.User.Views.registrologin;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@PageTitle("Login")
@Route(value = "/login")
public class login extends LoginOverlay implements BeforeEnterObserver, HasComponents {

    public login() {
        addClassName("loginView");
        setAction("login");

        LoginI18n i18n = LoginI18n.createDefault();
        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("StarPhone");
        i18n.setAdditionalInformation(null);

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Iniciar sesión");
        i18nForm.setUsername("Nombre de usuario");
        i18nForm.setPassword("Contraseña");
        i18nForm.setSubmit("Iniciar sesión");
        i18nForm.setForgotPassword("Recuperar contraseña");
        i18n.setForm(i18nForm);

        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("Algo ha salido mal");
        i18nErrorMessage.setMessage("Por favor reescriba que su contraseña y username estan bien escritos.");
        i18n.setErrorMessage(i18nErrorMessage);

        setI18n(i18n);

        setForgotPasswordButtonVisible(true);
        addForgotPasswordListener(e -> UI.getCurrent().navigate(ForgotPasswordView.class));
        setOpened(true);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            this.setError(true);
        }
    }
}