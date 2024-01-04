package com.application.User.Views;

import com.application.Contract.Entities.Contract;
import com.application.MobileLine.Entities.MobileLine;

import com.application.MobileLine.Service.MobileLineService;
import com.application.User.Security.AuthenticatedUser;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.textfield.IntegerField;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@RolesAllowed("CUSTOMER")

@CssImport("./styles/styles.css")
@PageTitle("Bloquear Número")
@Route(value = "/bloquearnumero", layout = menu.class)
public class BlockNumberUserView extends VerticalLayout {
    private final MobileLineService mobileService;
    AuthenticatedUser authenticatedUser;
    ComboBox<Contract> Contrato;
    ComboBox<MobileLine> linea;
    VerticalLayout bodyDiv, centerDiv, confirmSquare;
    HorizontalLayout titleDiv, footerDiv;
    H3 titleDelete;
    IntegerField phoneNumber;

    Button confirmar;

    public BlockNumberUserView(AuthenticatedUser authenticatedUser, MobileLineService mobileService) {
        this.authenticatedUser = authenticatedUser;
        this.mobileService = mobileService;

        setWidthFull();
        setHeightFull();
        addClassName("mainView");
        setPadding(false);
        setSpacing(false);
        getStyle().set("font-family", "Kavoon");

        // Campos formulario
        phoneNumber = new IntegerField("Número de teléfono:");
        phoneNumber.addClassName("activefield");
        phoneNumber.setId("phoneNumber");

        Contrato = new ComboBox<>("Contratos:");
        Contrato.addClassName("activefield");
        Contrato.setId("Contrato");
        Contrato.setRequired(true);
        Contrato.setHelperText("Seleccione un contrato de la lista.");
        // Mostrar en el combobox todos los contratos del usuario logueado
        List<Contract> l = authenticatedUser.get().get().getContracts();

        if (!l.isEmpty()) {
            Contrato.setItems(l);
            Contrato.setPlaceholder(String.valueOf(l.get(0)));
        }

        linea = new ComboBox<>("Líneas:");
        linea.addClassName("activefield");
        linea.setId("DNI");
        linea.setRequired(true);
        linea.setHelperText("Seleccione una línea de la lista.");

        Contrato.addValueChangeListener(event -> {
            List<MobileLine> ml = event.getValue().getMobileLines();
            if (!ml.isEmpty()) {
                linea.setItems(ml);
                linea.setPlaceholder(String.valueOf(ml.get(0)));
            }
        });

        confirmar = new Button("Bloquear");
        confirmar.addClassName("activebutton");
        confirmar.addClickListener(e -> onBlocknumber());
        // ---------------------------

        centerDiv = new VerticalLayout();
        centerDiv.setWidthFull();
        centerDiv.setPadding(false);
        centerDiv.setSpacing(false);
        centerDiv.setAlignItems(Alignment.CENTER);
        centerDiv.setJustifyContentMode(JustifyContentMode.CENTER);

        confirmSquare = new VerticalLayout();
        confirmSquare.setWidth("380px");
        confirmSquare.setHeight("400px");
        confirmSquare.setPadding(false);
        confirmSquare.setSpacing(false);
        confirmSquare.setAlignItems(Alignment.CENTER);
        confirmSquare.getStyle().set("border-radius", "12px");

        titleDiv = new HorizontalLayout();
        titleDiv.setWidthFull();
        titleDiv.setHeight("60px");
        titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        titleDiv.setAlignItems(Alignment.CENTER);
        titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
        titleDiv.getStyle().set("background-color", "rgb(135, 206, 235)");
        titleDelete = new H3("Bloquear número");
        titleDelete.getStyle().set("font-size", "28px");
        titleDelete.getStyle().set("color", "white");
        titleDiv.add(titleDelete);
        confirmSquare.add(titleDiv);

        bodyDiv = new VerticalLayout(Contrato, linea, phoneNumber, confirmar);
        bodyDiv.setWidthFull();
        bodyDiv.setJustifyContentMode(JustifyContentMode.START);
        bodyDiv.setAlignItems(Alignment.CENTER);
        bodyDiv.getStyle().set("background-color", "rgb(255, 255, 255)");
        bodyDiv.getStyle().set("border-radius", "0 0 12px 12px");
        confirmSquare.add(bodyDiv);

        centerDiv.add(confirmSquare);
        add(centerDiv);
        expand(centerDiv);
        expand(bodyDiv);

        centerDiv.add(confirmSquare);
        add(centerDiv);
        expand(centerDiv);
    }

    public void onBlocknumber() {
        if (phoneNumber.getValue() != null && Contrato.getValue() != null && linea.getValue() != null) {
            mobileService.blockNumber(phoneNumber.getValue(), linea.getValue());
            Notification.show("Número bloqueado");

        } else {
            Notification.show("Rellene todos los campos");

        }

    }

}