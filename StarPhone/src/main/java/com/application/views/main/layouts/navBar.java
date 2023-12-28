package com.application.views.main.layouts;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@CssImport("./styles/styles.css")
public class navBar extends HorizontalLayout {

    VerticalLayout firstDiv, secondDiv, thirdDiv, fourthDiv;
    Anchor a1, a2, a3, a4;

    public navBar() {
        setWidth(70, Unit.PERCENTAGE);
        setHeight("50px");
        getStyle().set("background-color", "rgba(135, 206, 235, 0.8)");
        getStyle().set("border", "2px solid black");
        getStyle().set("box-shadow", "4px rgba(0, 0, 0, 0.2)");
        setPadding(false);
        setSpacing(false);

        firstDiv = new VerticalLayout();
        firstDiv.addClassName("vlNavBar");
        a1 = new Anchor("#", "MÓVIL+FIBRA");
        a1.addClassName("anchor1");
        firstDiv.add(a1);
        add(firstDiv);

        secondDiv = new VerticalLayout();
        secondDiv.addClassName("vlNavBar");
        a2 = new Anchor("#", "OFERTAS");
        a2.addClassName("anchor1");
        secondDiv.add(a2);
        add(secondDiv);

        thirdDiv = new VerticalLayout();
        thirdDiv.addClassName("vlNavBar");
        add(thirdDiv);
        a3 = new Anchor("#", "ATENCIÓN AL CLIENTE");
        a3.addClassName("anchor1");
        thirdDiv.add(a3);

        fourthDiv = new VerticalLayout();
        fourthDiv.addClassName("vlNavBar");
        a4 = new Anchor("#", "NUESTROS VALORES");
        a4.addClassName("anchor1");
        fourthDiv.add(a4);
        add(fourthDiv);
    }

}
