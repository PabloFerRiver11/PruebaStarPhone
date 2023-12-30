package com.application.User.Views.menus;

import com.application.views.main.layouts.footer;
import com.application.views.main.layouts.header;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;

//@AnonymousAllowed
@RolesAllowed("Customer")
@CssImport("./styles/styles.css")
@PageTitle("Menu Cliente")
@Route(value = "/menucliente")
public class menuCustomer extends VerticalLayout {

    header h;
    VerticalLayout bodyDiv, centerDiv, confirmSquare;
    HorizontalLayout titleDiv, footerDiv;
    Button confirmar;
    footer f;

    public menuCustomer() {
        setWidthFull();

        setHeightFull();

        addClassName("mainView");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        header h = new header();
        add(h);

        centerDiv = new VerticalLayout();
        centerDiv.setWidthFull();
        centerDiv.setPadding(false);
        centerDiv.setSpacing(false);
        centerDiv.setAlignItems(Alignment.CENTER);
        centerDiv.setJustifyContentMode(JustifyContentMode.CENTER);

        confirmSquare = new VerticalLayout();
        confirmSquare.setWidth("350px");
        confirmSquare.setHeight("350px");
        confirmSquare.setPadding(false);
        confirmSquare.setSpacing(false);
        confirmSquare.setAlignItems(Alignment.CENTER);
        confirmSquare.getStyle().set("border-radius", "12px");
        confirmSquare.add(new Text("Bienvenido a StarPhone!"));

        bodyDiv = new VerticalLayout();
        bodyDiv.setWidth(100, Unit.PERCENTAGE);
        bodyDiv.setJustifyContentMode(JustifyContentMode.START);
        bodyDiv.setAlignItems(Alignment.CENTER);
        bodyDiv.getStyle().set("background-color", "rgb(255, 255, 255)");
        Button logoutButton = new Button("Logout", clickEvent -> {
            UI.getCurrent().getPage().setLocation("/logout");
        });
        logoutButton.addThemeName("Primary");
        bodyDiv.add(logoutButton);
        confirmSquare.add(bodyDiv);

        footerDiv = new HorizontalLayout();
        footerDiv.setWidth(100, Unit.PERCENTAGE);
        footerDiv.setHeight("60px");
        footerDiv.getStyle().set("border-radius", "0 0 12px 12px");
        footerDiv.getStyle().set("background-color", "rgb(135, 206, 235)");
        confirmSquare.add(footerDiv);
        expand(bodyDiv);

        centerDiv.add(confirmSquare);
        add(centerDiv);

        f = new footer();
        add(f);

        expand(centerDiv);
    }
}
