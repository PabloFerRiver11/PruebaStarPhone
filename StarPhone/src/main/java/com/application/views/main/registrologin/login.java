package com.application.views.main.registrologin;

import com.application.views.main.layouts.footer;
import com.application.views.main.layouts.header;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./styles/styles.css")
@PageTitle("InicioDeSesion")
@Route(value = "/login")
public class login extends VerticalLayout {

    header h;
    VerticalLayout centerDiv, loginSquare, bodyDiv;
    HorizontalLayout titleDiv, footerDiv;
    H3 inisesion;
    EmailField email;
    PasswordField password;
    Button confirmar;
    footer f;

    public login() {
        setWidthFull();
        setHeightFull();
        addClassName("mainView");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        h = new header();
        add(h);

        centerDiv = new VerticalLayout();
        centerDiv.setWidthFull();
        centerDiv.setPadding(false);
        centerDiv.setSpacing(false);
        centerDiv.setAlignItems(Alignment.CENTER);

        loginSquare = new VerticalLayout();
        loginSquare.setWidth("450px");
        loginSquare.setHeight("500px");
        loginSquare.getStyle().set("margin-top", "50px");
        loginSquare.setPadding(false);
        loginSquare.setSpacing(false);
        loginSquare.setAlignItems(Alignment.CENTER);
        loginSquare.getStyle().set("border-radius", "12px");

        titleDiv = new HorizontalLayout();
        titleDiv.setWidth(100, Unit.PERCENTAGE);
        titleDiv.setHeight("60px");
        titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        titleDiv.setAlignItems(Alignment.CENTER);
        titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
        titleDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.7)");
        inisesion = new H3("Iniciar Sesión");
        inisesion.getStyle().set("font-size", "32px");
        inisesion.getStyle().set("color", "white");
        titleDiv.add(inisesion);
        loginSquare.add(titleDiv);

        bodyDiv = new VerticalLayout();
        bodyDiv.setWidth(100, Unit.PERCENTAGE);
        bodyDiv.setJustifyContentMode(JustifyContentMode.START);
        bodyDiv.setAlignItems(Alignment.CENTER);
        bodyDiv.getStyle().set("background-color", "rgba(255, 255, 255, 0.9)");
        email = new EmailField("Correo Electrónico:");
        email.addClassName("loginformfield");
        email.setId("email");
        bodyDiv.add(email);
        password = new PasswordField("Contraseña:");
        password.addClassName("loginformfield");
        password.setId("password");
        bodyDiv.add(password);
        confirmar = new Button("Confirmar");
        confirmar.addClassName("loginformbutton");
        bodyDiv.add(confirmar);
        loginSquare.add(bodyDiv);

        footerDiv = new HorizontalLayout();
        footerDiv.setWidth(100, Unit.PERCENTAGE);
        footerDiv.setHeight("60px");
        footerDiv.getStyle().set("border-radius", "0 0 12px 12px");
        footerDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.7)");
        loginSquare.add(footerDiv);
        expand(bodyDiv);

        centerDiv.add(loginSquare);
        add(centerDiv);
        expand(centerDiv);

        footer f = new footer();
        add(f);
    }
}
