package com.application.views.main.layouts;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class footer extends VerticalLayout {

    public footer() {
        setWidthFull();
        setHeight("160px");
        getStyle().set("background-color", "rgba(135, 206, 235, 0.7)");
        setPadding(false);
        setSpacing(false);

        HorizontalLayout topDiv = new HorizontalLayout();
        topDiv.setWidth(100, Unit.PERCENTAGE);
        topDiv.setHeight(50, Unit.PERCENTAGE);

        HorizontalLayout leftTopDiv = new HorizontalLayout();
        leftTopDiv.setWidth(50, Unit.PERCENTAGE);
        leftTopDiv.setHeight(100, Unit.PERCENTAGE);
        leftTopDiv.setJustifyContentMode(JustifyContentMode.START);
        leftTopDiv.setAlignItems(Alignment.CENTER);
        H1 titulo = new H1("StarPhone");
        titulo.getStyle().set("font-size", "35px");
        titulo.getStyle().set("color", "white");
        titulo.getStyle().set("padding-left", "30px");
        leftTopDiv.add(titulo);
        topDiv.add(leftTopDiv);

        HorizontalLayout rightTopDiv = new HorizontalLayout();
        rightTopDiv.setWidth(50, Unit.PERCENTAGE);
        rightTopDiv.setHeight(100, Unit.PERCENTAGE);
        rightTopDiv.setJustifyContentMode(JustifyContentMode.END);
        rightTopDiv.setAlignItems(Alignment.CENTER);
        Anchor linkIg = new Anchor("https://www.instagram.com/");
        linkIg.addClassName("footerIcon1");
        Image iconIg = new Image("icons/iconIG.svg", "iconIg");
        iconIg.addClassName("footerIcon1");
        linkIg.add(iconIg);
        rightTopDiv.add(linkIg);
        Anchor linkTw = new Anchor("https://twitter.com/");
        linkTw.addClassName("footerIcon1");
        Image iconTw = new Image("icons/iconTw.svg", "iconTw");
        iconTw.addClassName("footerIcon1");
        linkTw.add(iconTw);
        rightTopDiv.add(linkTw);
        Anchor linkFb = new Anchor("https://facebook.com/");
        linkFb.addClassName("footerIcon2");
        Image iconFb = new Image("icons/iconFb.svg", "iconFb");
        iconFb.addClassName("footerIcon2");
        linkFb.add(iconFb);
        rightTopDiv.add(linkFb);
        topDiv.add(rightTopDiv);
        add(topDiv);

        HorizontalLayout bottomDiv = new HorizontalLayout();
        bottomDiv.setWidth(100, Unit.PERCENTAGE);
        bottomDiv.setHeight(50, Unit.PERCENTAGE);
        bottomDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        bottomDiv.setAlignItems(Alignment.END);
        bottomDiv.getStyle().set("gap", "200px");
        Anchor a1 = new Anchor("#", "Aviso Legal");
        a1.addClassName("anchor");
        bottomDiv.add(a1);
        Anchor a2 = new Anchor("#", "Política de Cookies");
        a2.addClassName("anchor");
        bottomDiv.add(a2);
        Anchor a3 = new Anchor("#", "Política de Privacidad");
        a3.addClassName("anchor");
        bottomDiv.add(a3);
        H3 a4 = new H3("Copyright© 2023. Todos los derechos reservados.");
        a4.addClassName("anchor");
        bottomDiv.add(a4);
        add(bottomDiv);
    }

}
