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
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@CssImport("./styles/styles.css")
@PageTitle("StarPhone")
@Route(value = "/")
public class MainView extends VerticalLayout {

    navBar m;
    VerticalLayout centerDiv, leftIntoCenterDiv, centerIntoCenterDiv, rightIntoCenterDiv;
    HorizontalLayout intoCenterDiv;
    Button butcustomer, butnocustomer;

    public MainView() {
        setWidthFull();
        setHeightFull();
        addClassName("mainView");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        add(new header());

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
        leftIntoCenterDiv.setWidth(33, Unit.PERCENTAGE);
        leftIntoCenterDiv.setHeightFull();
        leftIntoCenterDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        leftIntoCenterDiv.setAlignItems(Alignment.CENTER);
        butcustomer = new Button("Soy Cliente");
        butcustomer.addClickListener(e -> UI.getCurrent().getPage().setLocation("/menu"));
        butcustomer.addClassName("mainViewButton");
        butcustomer.getStyle().set("cursor", "pointer");
        leftIntoCenterDiv.add(butcustomer);
        intoCenterDiv.add(leftIntoCenterDiv);

        centerIntoCenterDiv = new VerticalLayout();
        centerIntoCenterDiv.setWidth(34, Unit.PERCENTAGE);
        centerIntoCenterDiv.setHeightFull();
        centerIntoCenterDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        centerIntoCenterDiv.setAlignItems(Alignment.CENTER);
        butnocustomer = new Button("Regístrate");
        butnocustomer.addClickListener(e -> UI.getCurrent().getPage().setLocation("/starphonetarifas"));
        butnocustomer.addClassName("mainViewButton");
        butnocustomer.getStyle().set("cursor", "pointer");
        centerIntoCenterDiv.add(butnocustomer);
        intoCenterDiv.add(centerIntoCenterDiv);

        rightIntoCenterDiv = new VerticalLayout();
        rightIntoCenterDiv.setWidth(33, Unit.PERCENTAGE);
        rightIntoCenterDiv.setHeightFull();
        rightIntoCenterDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        rightIntoCenterDiv.setAlignItems(Alignment.CENTER);
        butnocustomer = new Button("Soy Empleado");
        butnocustomer.addClickListener(e -> UI.getCurrent().getPage().setLocation("/menu"));
        butnocustomer.addClassName("mainViewButton");
        butnocustomer.getStyle().set("cursor", "pointer");
        rightIntoCenterDiv.add(butnocustomer);
        intoCenterDiv.add(rightIntoCenterDiv);

        centerDiv.add(intoCenterDiv);
        add(centerDiv);
        expand(centerDiv);

        add(new footer());
    }

}
