package com.application.views.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.application.views.main.layouts.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@CssImport("./styles/styles.css")
@PageTitle("Trabaja con Nosotros")
@Route(value = "/trabajaconnosotros")
public class WorkWithUs extends VerticalLayout {

        header h;
        H3 titleRegister, uno, dos, tres;
        H5 Bienvenida, Bienvenida1, QOfrece, QOfrece1, QOfrece2, QOfrece3, QOfrece4, QueBusc, SolTrabajo;
        HorizontalLayout titleDiv;
        VerticalLayout centerDiv, container, layoutTextoTrabajaConNosotros;
        Scroller bodyDiv;
        footer f;

        public WorkWithUs() {
                Bienvenida = new H5(
                                "¡Bienvenido a la página de empleo de StarPhone! Si estás interesado en formar parte de"
                                                +
                                                " nuestro equipo, estás en el lugar adecuado.");
                Bienvenida1 = new H5(
                                "En StarPhone valoramos a nuestros empleados y ofrecemos un entorno de trabajo" +
                                                " inclusivo y respetuoso. Contamos con una amplia variedad de puestos de trabajo y estamos siempre"
                                                +
                                                " buscando personas talentosas y comprometidas para unirse a nuestro equipo.");

                uno = new H3("1. ¿QUÉ OFRECEMOS A NUESTROS EMPLEADOS?");
                uno.getStyle().set("font-weight", "bold");
                QOfrece = new H5(
                                "En StarPhone ofrecemos a nuestros empleados una serie de beneficios para mejorar" +
                                                " su bienestar y su calidad de vida. Algunos de estos beneficios son:");
                QOfrece1 = new H5(
                                "*** Plan de formación y desarrollo: Contamos con un plan de formación y " +
                                                "desarrollo que te permitirá adquirir nuevas habilidades y conocimientos para tu carrera profesional.");
                QOfrece2 = new H5(
                                "*** Plan de salud: Ofrecemos a nuestros empleados un plan de salud que incluye" +
                                                " cobertura médica y dental, así como acceso a servicios de bienestar y prevención de enfermedades.");
                QOfrece3 = new H5(
                                "*** Plan de beneficios: Además, nuestros empleados pueden acceder a un plan de" +
                                                " beneficios que incluye descuentos en productos y servicios de StarPhone y de nuestras empresas asociadas,"
                                                +
                                                " así como en eventos y actividades culturales.");
                QOfrece4 = new H5("*** Horarios flexibles: Contamos con horarios flexibles y políticas de"
                                +
                                " teletrabajo para adaptarnos a las necesidades de nuestros empleados y mejorar su equilibrio entre la"
                                +
                                " vida laboral y personal.");

                dos = new H3("2. ¿QUÉ ESTAMOS BUSCANDO?");
                dos.getStyle().set("font-weight", "bold");
                QueBusc = new H5(
                                "Estamos buscando personas comprometidas y proactivas, con una actitud" +
                                                " positiva y un fuerte sentido de la responsabilidad. Si tienes experiencia en el sector financiero y"
                                                +
                                                " tienes una formación académica en economía, finanzas o carreras similares, podrías ser el candidato"
                                                +
                                                " perfecto para nosotros!");

                tres = new H3("3. ¿CÓMO PUEDO SOLICITAR UN PUESTO DE TRABAJO?");
                tres.getStyle().set("font-weight", "bold");
                SolTrabajo = new H5(
                                "Si estás interesado en unirte a nuestro equipo, puedes enviarnos tu" +
                                                " currículum a través de nuestro correo \"StarPhone@gmail.com\". Asegúrate de incluir una carta de motivación"
                                                +
                                                " y una descripción detallada de tus habilidades y experiencia relevantes. Si tu perfil encaja con alguna"
                                                +
                                                " de nuestras vacantes, nos pondremos en contacto contigo para programar una entrevista. ¡Esperamos "
                                                +
                                                "recibir tu candidatura pronto!");
                setWidthFull();
                setHeightFull();
                addClassName("mainView");
                setPadding(false);
                setSpacing(false);
                getStyle().set("font-family", "Kavoon");

                add(new header());

                centerDiv = new VerticalLayout();
                centerDiv.setWidthFull();
                centerDiv.setAlignItems(Alignment.CENTER);
                centerDiv.setJustifyContentMode(JustifyContentMode.CENTER);

                container = new VerticalLayout();
                container.setWidth("1400px");
                container.setHeight("600px");
                container.setPadding(false);
                container.setSpacing(false);
                container.setAlignItems(Alignment.CENTER);
                container.getStyle().set("border-radius", "12px");

                titleDiv = new HorizontalLayout();
                titleDiv.setWidthFull();
                titleDiv.setHeight("80px");
                titleDiv.setJustifyContentMode(JustifyContentMode.CENTER);
                titleDiv.setAlignItems(Alignment.CENTER);
                titleDiv.getStyle().set("border-radius", "12px 12px 0 0");
                titleDiv.getStyle().set("background-color", "rgb(135, 206, 235)");
                titleRegister = new H3("Trabaja con nosotros");
                titleRegister.getStyle().set("font-size", "38px");
                titleRegister.getStyle().set("color", "white");
                titleDiv.add(titleRegister);
                container.add(titleDiv);

                layoutTextoTrabajaConNosotros = new VerticalLayout();
                layoutTextoTrabajaConNosotros.add(Bienvenida, Bienvenida1,
                                uno, QOfrece, QOfrece1, QOfrece2, QOfrece3, QOfrece4,
                                dos, QueBusc, tres, SolTrabajo);
                bodyDiv = new Scroller(layoutTextoTrabajaConNosotros);
                bodyDiv.setWidthFull();
                bodyDiv.getStyle().set("border-radius", "0 0 12px 12px");
                bodyDiv.getStyle().set("background-color", "rgb(255, 255, 255)");

                container.add(bodyDiv);
                expand(bodyDiv);

                centerDiv.add(container);
                add(centerDiv);
                expand(centerDiv);

                add(new footer());
        }
}