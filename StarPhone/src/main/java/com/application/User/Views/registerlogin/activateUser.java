package com.application.User.Views.registerlogin;

import com.application.views.main.layouts.footer;
import com.application.views.main.layouts.header;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@CssImport("./styles/styles.css")
@PageTitle("Activar Usuario")
@Route(value = "/activaruser")
public class activateUser extends VerticalLayout {

    header h;
    VerticalLayout bodyDiv, centerDiv, confirmSquare;
    HorizontalLayout titleDiv, footerDiv;
    H3 confirmTitle;
    NumberField confirmCode;
    Button confirmar;
    footer f;

    public activateUser() {
        setWidthFull();
        setHeightFull();
        addClassName("mainView");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        // TODO: Comprobar si usuario está activado, entonces redirigir a su menú según
        // rol
        header h = new header();
        add(h);

        centerDiv = new VerticalLayout();
        centerDiv.setWidthFull();
        centerDiv.setPadding(false);
        centerDiv.setSpacing(false);
        centerDiv.setAlignItems(Alignment.CENTER);
        centerDiv.setJustifyContentMode(JustifyContentMode.CENTER);

        confirmSquare = new VerticalLayout();
        confirmSquare.setWidth("400px");
        confirmSquare.setHeight("400px");
        confirmSquare.setPadding(false);
        confirmSquare.setSpacing(false);
        confirmSquare.setAlignItems(Alignment.CENTER);
        confirmSquare.getStyle().set("border-radius", "12px");

        titleDiv = new HorizontalLayout();
        titleDiv.setWidth(100, Unit.PERCENTAGE);
        titleDiv.setHeight("60px");
        titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        titleDiv.setAlignItems(Alignment.CENTER);
        titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
        titleDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.8)");
        confirmTitle = new H3("Activar Usuario");
        confirmTitle.getStyle().set("font-size", "26px");
        confirmTitle.getStyle().set("color", "white");
        titleDiv.add(confirmTitle);
        confirmSquare.add(titleDiv);

        bodyDiv = new VerticalLayout();
        bodyDiv.setWidth(100, Unit.PERCENTAGE);
        bodyDiv.setJustifyContentMode(JustifyContentMode.START);
        bodyDiv.setAlignItems(Alignment.CENTER);
        bodyDiv.getStyle().set("background-color", "rgba(255, 255, 255, 0.9)");
        confirmCode = new NumberField("Código de activación:");
        confirmCode.addClassName("activefield");
        confirmCode.setId("confirmCode");
        bodyDiv.add(confirmCode);
        confirmar = new Button("Confirmar");
        confirmar.addClassName("activebutton");
        confirmar.addClickListener(e -> {
            // comparar código con el almacenado en la BD
            // dar rol al usuario como USER
            // activate a true
            // redirigi a su menú (menusuario)
        });
        bodyDiv.add(confirmar);
        confirmSquare.add(bodyDiv);

        footerDiv = new HorizontalLayout();
        footerDiv.setWidth(100, Unit.PERCENTAGE);
        footerDiv.setHeight("60px");
        footerDiv.getStyle().set("border-radius", "0 0 12px 12px");
        footerDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.8)");
        confirmSquare.add(footerDiv);
        expand(bodyDiv);

        centerDiv.add(confirmSquare);
        add(centerDiv);

        f = new footer();
        add(f);

        expand(centerDiv);
    }
}