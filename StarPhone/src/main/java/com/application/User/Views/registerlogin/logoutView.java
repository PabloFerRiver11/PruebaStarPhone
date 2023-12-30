package com.application.User.Views.registerlogin;

import com.application.User.Security.AuthenticatedUser;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import jakarta.annotation.security.PermitAll;

@AnonymousAllowed
@PermitAll
@Route("/logout")
public class logoutView extends VerticalLayout {

    private final AuthenticatedUser authenticatedUser;
    private final UI ui;

    public logoutView(AuthenticatedUser authUser) {
        authenticatedUser = authUser;
        this.ui = UI.getCurrent();

        authenticatedUser.logout();
        ui.access(() -> {
            ui.navigate(""); // Navega a la vista principal después de cerrar la sesión
        });
    }
}