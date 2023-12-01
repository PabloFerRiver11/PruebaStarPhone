package com.application.views.main;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.application.views.main.layouts.*;

@CssImport("./styles/styles.css")
@PageTitle("StarPhone")
@Route(value = "/")
public class MainView extends VerticalLayout {

    header h;
    navBar m;
    VerticalLayout centerDiv, leftIntoCenterDiv, rightIntoCenterDiv;
    footer f;
    HorizontalLayout intoCenterDiv;
    Button butcliente, butnocliente;

    public MainView() {
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
        centerDiv.getStyle().set("gap", "140px");
        centerDiv.setAlignItems(Alignment.CENTER);

        m = new navBar();
        centerDiv.add(m);

        intoCenterDiv = new HorizontalLayout();
        intoCenterDiv.setWidth(60, Unit.PERCENTAGE);
        intoCenterDiv.setHeight("250px");
        intoCenterDiv.getStyle().set("background-color", "rgba(255, 255, 255, 0.2)");

        leftIntoCenterDiv = new VerticalLayout();
        leftIntoCenterDiv.setWidth(50, Unit.PERCENTAGE);
        leftIntoCenterDiv.setHeight(100, Unit.PERCENTAGE);
        leftIntoCenterDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        leftIntoCenterDiv.setAlignItems(Alignment.CENTER);
        butcliente = new Button("Soy Cliente");
        butcliente.addClickListener(e -> UI.getCurrent().getPage().setLocation("/login"));
        butcliente.addClassName("mainViewButton");
        butcliente.getStyle().set("cursor", "pointer");
        leftIntoCenterDiv.add(butcliente);
        intoCenterDiv.add(leftIntoCenterDiv);

        rightIntoCenterDiv = new VerticalLayout();
        rightIntoCenterDiv.setWidth(50, Unit.PERCENTAGE);
        rightIntoCenterDiv.setHeight(100, Unit.PERCENTAGE);
        rightIntoCenterDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        rightIntoCenterDiv.setAlignItems(Alignment.CENTER);
        butnocliente = new Button("Regístrate");
        butnocliente.addClickListener(e -> UI.getCurrent().getPage().setLocation("/registro"));
        butnocliente.addClassName("mainViewButton");
        butnocliente.getStyle().set("cursor", "pointer");
        rightIntoCenterDiv.add(butnocliente);
        intoCenterDiv.add(rightIntoCenterDiv);

        centerDiv.add(intoCenterDiv);
        add(centerDiv);
        expand(centerDiv);

        f = new footer();
        add(f);

    }
}
