package com.application.User.Views;

import com.application.User.Services.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@AnonymousAllowed
// TODO: @RolesAllowed("ROLE_ADMIN") + import jakarta.annotation
@CssImport("./styles/styles.css")
@PageTitle("Borrar Usuario")
@Route(value = "/borrarusuario", layout = menu.class)
public class adminDeleteUserView extends VerticalLayout {

    VerticalLayout bodyDiv, centerDiv, confirmSquare;
    HorizontalLayout titleDiv, footerDiv;
    H3 titleDelete;
    EmailField email;
    ComboBox<String> DNI;
    Button confirmar;
    UserService userService;

    public adminDeleteUserView(UserService uService) {
        userService = uService;
        setWidthFull();
        setHeightFull();
        addClassName("mainView");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        // Campos formulario
        email = new EmailField("Email:");
        email.addClassName("activefield");
        email.setId("email");
        email.setRequired(true);
        email.setHelperText("Introduce un email, para obtener un DNI.");
        email.setValueChangeMode(ValueChangeMode.EAGER);

        DNI = new ComboBox<>("DNI:");
        DNI.addClassName("activefield");
        DNI.setId("DNI");
        DNI.setRequired(true);
        DNI.setHelperText("Seleccione un DNI de la lista.");

        email.addValueChangeListener(event -> {
            List<String> l = userService.getDNIByEmail(event.getValue());
            if (l.size() > 0) {
                DNI.setItems(l);
                DNI.setPlaceholder(l.get(0));
            }
        });

        confirmar = new Button("Confirmar");
        confirmar.addClassName("activebutton");
        confirmar.addClickListener(e -> onDeleteButtonClick());
        // ---------------------------

        centerDiv = new VerticalLayout();
        centerDiv.setWidthFull();
        centerDiv.setPadding(false);
        centerDiv.setSpacing(false);
        centerDiv.setAlignItems(Alignment.CENTER);
        centerDiv.setJustifyContentMode(JustifyContentMode.CENTER);

        confirmSquare = new VerticalLayout();
        confirmSquare.setWidth("380px");
        confirmSquare.setHeight("400px");
        confirmSquare.setPadding(false);
        confirmSquare.setSpacing(false);
        confirmSquare.setAlignItems(Alignment.CENTER);
        confirmSquare.getStyle().set("border-radius", "12px");

        titleDiv = new HorizontalLayout();
        titleDiv.setWidthFull();
        titleDiv.setHeight("60px");
        titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        titleDiv.setAlignItems(Alignment.CENTER);
        titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
        titleDiv.getStyle().set("background-color", "rgb(135, 206, 235)");
        titleDelete = new H3("Borrar Usuario");
        titleDelete.getStyle().set("font-size", "28px");
        titleDelete.getStyle().set("color", "white");
        titleDiv.add(titleDelete);
        confirmSquare.add(titleDiv);

        bodyDiv = new VerticalLayout(email, DNI, confirmar);
        bodyDiv.setWidthFull();
        bodyDiv.setJustifyContentMode(JustifyContentMode.START);
        bodyDiv.setAlignItems(Alignment.CENTER);
        bodyDiv.getStyle().set("background-color", "rgb(255, 255, 255)");
        bodyDiv.getStyle().set("border-radius", "0 0 12px 12px");
        confirmSquare.add(bodyDiv);

        centerDiv.add(confirmSquare);
        add(centerDiv);
        expand(centerDiv);
        expand(bodyDiv);

        centerDiv.add(confirmSquare);
        add(centerDiv);
        expand(centerDiv);
    }

    public void onDeleteButtonClick() {
        System.out.println(email.getValue());
        System.out.println(DNI.getValue());
        if (userService.deleteByDNI(DNI.getValue())) {
            String text = new String("Genial. Eliminado correctamente!!");
            Notification.show(text).addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        } else {
            String text = new String("Algo falló! Inténtelo de nuevo.");
            Notification.show(text).addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
    }
}