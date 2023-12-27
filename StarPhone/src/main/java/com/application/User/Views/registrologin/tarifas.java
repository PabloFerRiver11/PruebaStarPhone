package com.application.User.Views.registrologin;

import com.application.views.main.layouts.footer;
import com.application.views.main.layouts.header;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@CssImport("./styles/styles.css")
@PageTitle("Tarifas")
@Route(value = "/tarifas")
public class tarifas extends VerticalLayout {

    header h;
    VerticalLayout centerDiv;
    HorizontalLayout contratos, contratos2;
    contrato cont1, cont2, cont3, cont4, cont5;
    footer f;

    public tarifas() {
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
        contratos.setHeight(50, Unit.PERCENTAGE);
        contratos.setPadding(false);
        contratos.setSpacing(false);
        contratos.setJustifyContentMode(JustifyContentMode.CENTER);
        contratos.setAlignItems(Alignment.CENTER);
        contratos.getStyle().set("gap", "60px");

        cont1 = new contrato("Tarifa 1", "100 minutos", "1GB", 10);
        contratos.add(cont1);

        cont2 = new contrato("Tarifa 2", "100 minutos", "1GB", 10);
        contratos.add(cont2);

        cont3 = new contrato("Tarifa 3", "100 minutos", "1GB", 10);
        contratos.add(cont3);

        cont4 = new contrato("Tarifa 4", "100 minutos", "1GB", 10);
        contratos.add(cont4);

        centerDiv.add(contratos);

        add(centerDiv);
        expand(centerDiv);

        footer f = new footer();
        add(f);
    }
}
