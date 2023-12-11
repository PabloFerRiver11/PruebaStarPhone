package com.application.views.main.registrologin;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class contrato extends VerticalLayout {

    HorizontalLayout titleDiv, footerDiv;
    VerticalLayout bodyDiv;
    H3 titleText;

    public contrato(String title, String desc1, String desc2, float p) {
        setWidth("400px");
        setHeight("360px");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        titleDiv = new HorizontalLayout();
        titleDiv.setWidth(100, Unit.PERCENTAGE);
        titleDiv.setHeight("60px");
        titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        titleDiv.setAlignItems(Alignment.CENTER);
        titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
        titleDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.7)");
        titleText = new H3(title);
        titleText.getStyle().set("font-size", "24px");
        titleText.getStyle().set("color", "white");
        titleDiv.add(titleText);
        add(titleDiv);

        bodyDiv = new VerticalLayout();
        bodyDiv.setWidth(100, Unit.PERCENTAGE);
        bodyDiv.setJustifyContentMode(JustifyContentMode.START);
        bodyDiv.setAlignItems(Alignment.CENTER);
        getStyle().set("background-color", "rgba(255, 255, 255, 0.7)");
        add(bodyDiv);

        footerDiv = new HorizontalLayout();
        footerDiv.setWidth(100, Unit.PERCENTAGE);
        footerDiv.setHeight("60px");
        footerDiv.getStyle().set("border-radius", "0 0 12px 12px");
        footerDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.7)");
        add(footerDiv);
        expand(bodyDiv);
    }
}
