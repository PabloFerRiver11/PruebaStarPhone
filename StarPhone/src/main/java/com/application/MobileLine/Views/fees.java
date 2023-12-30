package com.application.MobileLine.Views;

import com.application.Contract.Views.contracts;
import com.application.views.main.layouts.footer;
import com.application.views.main.layouts.header;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
// TODO: @PermitAll + import jakarta.annotation.security.PermitAll;
@CssImport("./styles/styles.css")
@PageTitle("Tarifas")
@Route(value = "/tarifas")
public class fees extends VerticalLayout {

    header h;
    VerticalLayout centerDiv;
    HorizontalLayout contratos;
    contracts cont;
    Button butCont;
    footer f;

    public fees() {
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
        centerDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        centerDiv.setAlignItems(Alignment.CENTER);

        contratos = new HorizontalLayout();
        contratos.setWidthFull();
        contratos.setHeight(90, Unit.PERCENTAGE);
        contratos.setPadding(false);
        contratos.setSpacing(false);
        contratos.setJustifyContentMode(JustifyContentMode.CENTER);
        contratos.setAlignItems(Alignment.CENTER);
        contratos.getStyle().set("gap", "60px");

        for (int i = 1; i <= 4; i++) {
            // Recuperar descripción y precio de la base de datos
            cont = new contracts("Tarifa " + i,
                    "4 líneas para Toda la Familia. " +
                            "Llamadas y mensajes ilimitados. " +
                            "Datos compartidos entre todas las líneas. " +
                            "Control parental y funciones de seguridad. ",
                    "Conexión de fibra simétrica de 300 Mbps.",
                    "A elegir entre plataformas o canales.", 55);
            contratos.add(cont);
        }

        centerDiv.add(contratos);

        // if(user.activate() != true)
        butCont = new Button("Continuar");
        butCont.setWidth("245px");
        butCont.setHeight("70px");
        butCont.getStyle().set("font-size", "26px");
        butCont.getStyle().set("margin-bottom", "20px");
        butCont.addClickListener(e -> UI.getCurrent().getPage().setLocation("/registro"));
        butCont.addClassName("mainViewButton");
        butCont.getStyle().set("cursor", "pointer");

        centerDiv.add(butCont);
        add(centerDiv);
        expand(centerDiv);

        footer f = new footer();
        add(f);
    }
}
