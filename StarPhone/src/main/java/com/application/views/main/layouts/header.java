package com.application.views.main.layouts;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class header extends HorizontalLayout {

    HorizontalLayout leftDiv, centerDiv, rightDiv;
    H1 titulo;
    Image logo, start;

    public header() {
        setWidthFull();
        setHeight("80px");
        getStyle().set("background-color", "rgb(135, 206, 235)");
        setPadding(false);
        setSpacing(false);

        leftDiv = new HorizontalLayout();
        leftDiv.setWidth(33, Unit.PERCENTAGE);
        leftDiv.setHeight(100, Unit.PERCENTAGE);
        leftDiv.setJustifyContentMode(JustifyContentMode.START);
        leftDiv.setAlignItems(Alignment.CENTER);
        logo = new Image("images/icoSP.ico", "StarPhone");
        logo.setWidth("70px");
        logo.setHeight("70px");
        logo.getStyle().set("padding-left", "5px");
        leftDiv.add(logo);
        add(leftDiv);

        centerDiv = new HorizontalLayout();
        centerDiv.setWidth(34, Unit.PERCENTAGE);
        centerDiv.setHeight(100, Unit.PERCENTAGE);
        centerDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        centerDiv.setAlignItems(Alignment.CENTER);
        titulo = new H1("StarPhone");
        titulo.getStyle().set("font-size", "45px");
        titulo.getStyle().set("color", "white");
        centerDiv.add(titulo);
        add(centerDiv);

        rightDiv = new HorizontalLayout();
        rightDiv.setWidth(33, Unit.PERCENTAGE);
        rightDiv.setHeight(100, Unit.PERCENTAGE);
        rightDiv.setJustifyContentMode(JustifyContentMode.END);
        rightDiv.setAlignItems(Alignment.CENTER);
        start = new Image("images/Star.svg", "Star");
        start.getStyle().set("width", "65px");
        start.getStyle().set("height", "65px");
        start.getStyle().set("padding-right", "10px");
        rightDiv.add(start);
        add(rightDiv);
    }
}
