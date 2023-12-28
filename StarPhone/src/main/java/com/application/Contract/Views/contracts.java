package com.application.Contract.Views;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class contracts extends VerticalLayout {

    HorizontalLayout titleDiv, footerDiv;
    VerticalLayout bodyDiv;
    H3 titleText, monthlyPriceField;

    public contracts(String title, String descMobile, String descFiber, String descTV, double p) {
        setWidth("400px");
        setHeight("480px");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        titleDiv = new HorizontalLayout();
        titleDiv.setWidth(100, Unit.PERCENTAGE);
        titleDiv.setHeight("60px");
        titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        titleDiv.setAlignItems(Alignment.CENTER);
        titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
        titleDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.8)");
        titleText = new H3(title);
        titleText.getStyle().set("font-size", "24px");
        titleText.getStyle().set("color", "white");
        titleDiv.add(titleText);
        add(titleDiv);

        bodyDiv = new VerticalLayout();
        bodyDiv.setWidth(100, Unit.PERCENTAGE);
        bodyDiv.setJustifyContentMode(JustifyContentMode.START);
        bodyDiv.setAlignItems(Alignment.CENTER);
        bodyDiv.getStyle().set("background-color", "rgba(255, 255, 255, 0.8)");
        bodyDiv.add(new H3("Móvil"));
        bodyDiv.add(new H4(descMobile));
        bodyDiv.add(new H3("Fibra"));
        bodyDiv.add(new H4(descFiber));
        bodyDiv.add(new H3("TV"));
        bodyDiv.add(new H4(descTV));
        add(bodyDiv);

        footerDiv = new HorizontalLayout();
        footerDiv.setWidth(100, Unit.PERCENTAGE);
        footerDiv.setHeight("60px");
        footerDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        footerDiv.setAlignItems(Alignment.CENTER);
        footerDiv.getStyle().set("border-radius", "0 0 12px 12px");
        footerDiv.getStyle().set("background-color", "rgba(135, 206, 235, 0.8)");
        monthlyPriceField = new H3("Precio mensual: " + p + " €");
        monthlyPriceField.getStyle().set("font-size", "24px");
        monthlyPriceField.getStyle().set("color", "white");
        footerDiv.add(monthlyPriceField);
        add(footerDiv);
        expand(bodyDiv);
    }
}
