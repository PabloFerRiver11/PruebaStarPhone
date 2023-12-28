package com.application.User.Views.registerlogin;

import com.application.views.main.layouts.footer;
import com.application.views.main.layouts.header;
import com.application.User.Services.UserService;
import com.application.User.Entities.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@AnonymousAllowed
@CssImport("./styles/styles.css")
@PageTitle("Registro")
@Route(value = "/registro")
public class register extends VerticalLayout {

    header h;
    HorizontalLayout titleDiv, centerDiv, bodySubDiv1, bodySubDiv2, bodySubDiv3,
            bodySubDiv4, bodySubDiv5, footerDiv;
    VerticalLayout center, bodyDiv, registerForm;
    H3 titleRegister;
    private final TextField name, surname, username, country, DNI, city;
    private final DatePicker birthdate;
    private final EmailField email;
    private final NumberField phone;
    private final PasswordField password, repeatpassword;
    private final Select<String> fees;
    private final Button confirmar;
    private final BeanValidationBinder<User> binder;
    private final UserService service;
    footer f;

    public register(UserService service) {
        setWidthFull();
        setHeightFull();
        addClassName("mainView");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        header h = new header();
        add(h);

        center = new VerticalLayout();
        center.setWidthFull();
        center.setPadding(false);
        center.setSpacing(false);
        center.setAlignItems(Alignment.CENTER);
        center.setJustifyContentMode(JustifyContentMode.CENTER);

        registerForm = new VerticalLayout();
        registerForm.setWidth("1200px");
        registerForm.setHeight("600px");
        registerForm.setPadding(false);
        registerForm.setSpacing(false);
        registerForm.setAlignItems(Alignment.CENTER);
        registerForm.getStyle().set("border-radius", "12px");

        // Campos formulario ------------------------------
        DNI = new TextField("DNI:");
        DNI.addClassName("registerformfield");
        DNI.setMinLength(9);
        DNI.setMaxLength(9);
        DNI.setId("DNI");

        name = new TextField("Nombre:");
        name.addClassName("registerformfield");
        name.setId("name");

        surname = new TextField("Apellido:");
        surname.addClassName("registerformfield");
        surname.setId("surname");

        username = new TextField("Nombre de Usuario:");
        username.addClassName("registerformfield");
        username.setId("username");

        city = new TextField("Ciudad:");
        city.addClassName("registerformfield");
        city.setId("city");

        country = new TextField("País:");
        country.addClassName("registerformfield");
        country.setId("country");

        birthdate = new DatePicker("Fecha de Nacimiento:");
        birthdate.addClassName("registerformfield");
        birthdate.setId("birthdate");

        phone = new NumberField("Teléfono:");
        phone.addClassName("registerformfield");
        phone.setId("phone");

        email = new EmailField("Correo Electrónico:");
        email.addClassName("registerformfield");
        email.setId("email");

        password = new PasswordField("Contraseña:");
        password.addClassName("registerformfield");
        password.setId("password");

        repeatpassword = new PasswordField("Repetir Contraseña:");
        repeatpassword.addClassName("registerformfield");
        repeatpassword.setId("repeatpassword");

        fees = new Select<>();
        fees.addClassName("registerformfield");
        fees.setLabel("Tarifa:");
        fees.setItems("Tarifa 1", "Tarifa 2", "Tarifa 3", "Tarifa 4");
        fees.setValue("Tarifa 1");

        confirmar = new Button("Registrarse");
        confirmar.addClassName("registerformbutton");
        confirmar.addClickListener(e -> {
            // TODO: comprobar que los campos obligatorios están rellenos
            // TODO: comprobar que las contraseñas coinciden
            // TODO: comprobar que ningún campo (unique) este ya registrado
            UI.getCurrent().getPage().setLocation("/activaruser");
        });

        // -------------------------------------------------

        titleDiv = new HorizontalLayout();
        titleDiv.setWidth(100, Unit.PERCENTAGE);
        titleDiv.setHeight("60px");
        titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        titleDiv.setAlignItems(Alignment.CENTER);
        titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
        titleDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.9)");
        titleRegister = new H3("Hazte Cliente");
        titleRegister.getStyle().set("font-size", "32px");
        titleRegister.getStyle().set("color", "white");
        titleDiv.add(titleRegister);
        registerForm.add(titleDiv);

        bodyDiv = new VerticalLayout();
        bodyDiv.setWidth(100, Unit.PERCENTAGE);
        bodyDiv.setPadding(false);
        bodyDiv.setSpacing(false);
        bodyDiv.getStyle().set("background-color", "rgba(255, 255, 255, 1)");

        bodySubDiv1 = new HorizontalLayout(name, surname, DNI);
        bodySubDiv1.addClassName("bodysregister");
        bodySubDiv2 = new HorizontalLayout(username, birthdate, fees);
        bodySubDiv2.addClassName("bodysregister");
        bodySubDiv3 = new HorizontalLayout(email, password, repeatpassword);
        bodySubDiv3.addClassName("bodysregister");
        bodySubDiv4 = new HorizontalLayout(phone, city, country);
        bodySubDiv4.addClassName("bodysregister");
        bodySubDiv5 = new HorizontalLayout(confirmar);
        bodySubDiv5.addClassName("bodysregister");

        bodyDiv.add(bodySubDiv1, bodySubDiv2, bodySubDiv3, bodySubDiv4, bodySubDiv5);
        registerForm.add(bodyDiv);

        footerDiv = new HorizontalLayout();
        footerDiv.setWidth(100, Unit.PERCENTAGE);
        footerDiv.setHeight("60px");
        footerDiv.getStyle().set("border-radius", "0 0 12px 12px");
        footerDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.9)");
        registerForm.add(footerDiv);
        expand(bodyDiv);

        center.add(registerForm);
        add(center);
        expand(center);

        footer f = new footer();
        add(f);

        // Registro USUARIO
        this.service = service;
        binder = new BeanValidationBinder<>(User.class);
        binder.bindInstanceFields(this);
        binder.setBean(new User());
    }

    public void onRegisterButtonClick() {

        if (binder.validate().isOk() & password.getValue().equals(repeatpassword.getValue())) {
            if (service.registerUser(binder.getBean())) {
                // status.setText("Great. Please look at your mail inbox!");
                // status.setVisible(true);
                binder.setBean(new User());
                repeatpassword.setValue("");
            } else {
                Notification.show("Please, the username is already in use");

            }

        } else {
            Notification.show("Please, check input data");
        }

    }
}