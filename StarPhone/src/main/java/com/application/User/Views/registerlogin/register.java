package com.application.User.Views.registerlogin;

import com.application.views.main.layouts.footer;
import com.application.views.main.layouts.header;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@CssImport("./styles/styles.css")
@PageTitle("Registro")
@Route(value = "/registro")
public class register extends VerticalLayout {

    header h;
    VerticalLayout centerDiv, registerSquare, bodyLeftDiv, bodyCenterDiv, bodyRightDiv;
    HorizontalLayout titleDiv, bodyDiv, footerDiv, footerBodyDiv, footerBodyDivLeft, footerBodyDivRight;
    H3 register;
    TextField username, surname, country, DNI, city;
    Select<String> agreement;
    NumberField phone;
    DatePicker birthdate;
    EmailField email;
    PasswordField password, repetpassword;
    RadioButtonGroup<String> sexo;
    CheckboxGroup<String> policies;
    Button confirmar;
    footer f;

    public register() {
        setWidthFull();
        setHeightFull();
        addClassName("mainView");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        header h = new header();
        add(h);

        centerDiv = new VerticalLayout();
        centerDiv.setWidthFull();
        centerDiv.setPadding(false);
        centerDiv.setSpacing(false);
        centerDiv.setAlignItems(Alignment.CENTER);
        centerDiv.setJustifyContentMode(JustifyContentMode.CENTER);

        registerSquare = new VerticalLayout();
        registerSquare.setWidth("1200px");
        registerSquare.setHeight("600px");
        registerSquare.getStyle().set("margin-top", "10px");
        registerSquare.setPadding(false);
        registerSquare.setSpacing(false);
        registerSquare.setAlignItems(Alignment.CENTER);
        registerSquare.getStyle().set("border-radius", "12px");

        titleDiv = new HorizontalLayout();
        titleDiv.setWidth(100, Unit.PERCENTAGE);
        titleDiv.setHeight("60px");
        titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        titleDiv.setAlignItems(Alignment.CENTER);
        titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
        titleDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.8)");
        register = new H3("Hazte Cliente");
        register.getStyle().set("font-size", "32px");
        register.getStyle().set("color", "white");
        titleDiv.add(register);
        registerSquare.add(titleDiv);

        bodyDiv = new HorizontalLayout();
        bodyDiv.setWidth(100, Unit.PERCENTAGE);
        bodyDiv.setPadding(false);
        bodyDiv.setSpacing(false);
        bodyDiv.getStyle().set("background-color", "rgba(255, 255, 255, 0.9)");

        bodyLeftDiv = new VerticalLayout();
        bodyLeftDiv.addClassName("bodysregister");
        bodyLeftDiv.setSpacing(false);
        username = new TextField("Nombre:");
        username.addClassName("registerformfield");
        username.setId("username");
        bodyLeftDiv.add(username);
        birthdate = new DatePicker("Fecha de Nacimiento:");
        birthdate.addClassName("registerformfield");
        birthdate.setId("birthdate");
        bodyLeftDiv.add(birthdate);
        email = new EmailField("Correo Electrónico:");
        email.addClassName("registerformfield");
        email.setId("email");
        bodyLeftDiv.add(email);
        phone = new NumberField("Teléfono:");
        phone.addClassName("registerformfield");
        phone.setId("phone");
        bodyLeftDiv.add(phone);
        bodyDiv.add(bodyLeftDiv);

        bodyCenterDiv = new VerticalLayout();
        bodyCenterDiv.addClassName("bodysregister");
        bodyCenterDiv.setSpacing(false);
        surname = new TextField("Apellido:");
        surname.addClassName("registerformfield");
        surname.setId("surname");
        bodyCenterDiv.add(surname);
        sexo = new RadioButtonGroup<>();
        sexo.addClassName("registerformfield");
        sexo.setLabel("Sexo:");
        sexo.setItems("Hombre", "Mujer", "Otros");
        sexo.setId("sexo");
        bodyCenterDiv.add(sexo);
        password = new PasswordField("Contraseña:");
        password.addClassName("registerformfield");
        password.setId("password");
        bodyCenterDiv.add(password);
        city = new TextField("Ciudad:");
        city.addClassName("registerformfield");
        city.setId("city");
        bodyCenterDiv.add(city);
        bodyDiv.add(bodyCenterDiv);

        bodyRightDiv = new VerticalLayout();
        bodyRightDiv.addClassName("bodysregister");
        bodyRightDiv.setSpacing(false);
        DNI = new TextField("DNI:");
        DNI.addClassName("registerformfield");
        DNI.setId("DNI");
        bodyRightDiv.add(DNI);
        agreement = new Select<>();
        agreement.addClassName("registerformfield");
        agreement.setLabel("Seleccione una tarifa:");
        agreement.setItems("Tarifa 1", "Tarifa 2", "Tarifa 3", "Tarifa 4");
        agreement.setValue("Tarifa 1");
        bodyRightDiv.add(agreement);
        repetpassword = new PasswordField("Repetir Contraseña:");
        repetpassword.addClassName("registerformfield");
        repetpassword.setId("repetpassword");
        bodyRightDiv.add(repetpassword);
        country = new TextField("País:");
        country.addClassName("registerformfield");
        country.setId("country");
        bodyRightDiv.add(country);
        bodyDiv.add(bodyRightDiv);
        registerSquare.add(bodyDiv);

        footerBodyDiv = new HorizontalLayout();
        footerBodyDiv.setWidth("100%");
        footerBodyDiv.setHeight("140px");
        footerBodyDiv.setPadding(false);
        footerBodyDiv.setSpacing(false);
        footerBodyDiv.getStyle().set("background-color", "rgba(255, 255, 255, 0.9)");

        footerBodyDivLeft = new HorizontalLayout();
        footerBodyDivLeft.setWidth("50%");
        footerBodyDivLeft.setHeightFull();
        footerBodyDivLeft.setPadding(false);
        footerBodyDivLeft.setSpacing(false);
        footerBodyDivLeft.setAlignItems(Alignment.CENTER);
        policies = new CheckboxGroup<>();
        policies.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        policies.addClassName("registerformfield");
        policies.setWidthFull();
        policies.setHeightFull();
        policies.getStyle().set("padding-top", "30px");
        policies.getStyle().set("padding-left", "20px");
        policies.setLabel("Políticas:");
        policies.setItems("He leído y acepto las Condiciones de Uso y la Política de Privacidad.",
                "Deseo recibir información comercial y promociones por correo electrónico.");
        policies.setId("policies");
        policies.setRequired(true); // Mirar Importante
        footerBodyDivLeft.add(policies);
        footerBodyDiv.add(footerBodyDivLeft);

        footerBodyDivRight = new HorizontalLayout();
        footerBodyDivRight.setWidth("50%");
        footerBodyDivRight.setHeightFull();
        footerBodyDiv.setPadding(false);
        footerBodyDiv.setSpacing(false);
        footerBodyDivRight.setJustifyContentMode(JustifyContentMode.CENTER);
        footerBodyDivRight.setAlignItems(Alignment.CENTER);
        confirmar = new Button("Registrarse");
        confirmar.addClassName("registerformbutton");
        confirmar.addClickListener(e -> {
            Notification.show("Registrado Correctamente");
            UI.getCurrent().getPage().setLocation("/activaruser");
        });
        footerBodyDivRight.add(confirmar);

        footerBodyDiv.add(footerBodyDivRight);
        registerSquare.add(footerBodyDiv);

        footerDiv = new HorizontalLayout();
        footerDiv.setWidth(100, Unit.PERCENTAGE);
        footerDiv.setHeight("60px");
        footerDiv.getStyle().set("border-radius", "0 0 12px 12px");
        footerDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.8)");
        registerSquare.add(footerDiv);
        expand(bodyDiv);

        centerDiv.add(registerSquare);
        add(centerDiv);
        expand(centerDiv);
        footer f = new footer();
        add(f);
    }
}