package com.application.views.main;


import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.application.views.main.layouts.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

@AnonymousAllowed
@CssImport("./styles/styles.css")
@PageTitle("Trabaja con nosotros")
@Route(value = "trabaja")
public class WorkWithUs extends VerticalLayout {

    header h;
    navBar m;
    VerticalLayout centerDiv, leftIntoCenterDiv, centerIntoCenterDiv, rightIntoCenterDiv;
    footer f;
    HorizontalLayout intoCenterDiv;
    Button butcustomer, butnocustomer;

    public WorkWithUs() {
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


        VerticalLayout layoutTrabajaConNosotros = new VerticalLayout();
        VerticalLayout layoutTextoTrabajaConNosotros = new VerticalLayout();
        H1 Titulo = new H1("Trabaja con nosotros");
        H5 Bienvenida = new H5("Bienvenido a la pgina de empleo de StarPhone! Si ests interesado en formar parte de" +
                " nuestro equipo, ests en el lugar adecuado.");
        H5 TextoBienvenida1 = new H5("En StarPhone valoramos a nuestros empleados y ofrecemos un entorno de trabajo" +
                " inclusivo y respetuoso. Contamos con una amplia variedad de puestos de trabajo y estamos siempre" +
                " buscando personas talentosas y comprometidas para unirse a nuestro equipo.");
        HorizontalLayout layoutQueOfrecemos = new HorizontalLayout();
        H4 Primero = new H4("1.");
        H4 QueOfrecemos = new H4("Qu ofrecemos a nuestros empleados?");
        H5 TextoQueOfrecemos = new H5("En StarPhone ofrecemos a nuestros empleados una serie de beneficios para mejorar" +
                " su bienestar y su calidad de vida. Algunos de estos beneficios son:");
        H5 TextoQueOfrecemos1 = new H5(" Plan de formacin y desarrollo: Contamos con un plan de formacin y " +
                "desarrollo que te permitir adquirir nuevas habilidades y conocimientos para tu carrera profesional.");
        H5 TextoQueOfrecemos2 = new H5(" Plan de salud: Ofrecemos a nuestros empleados un plan de salud que incluye" +
                " cobertura mdica y dental, as como acceso a servicios de bienestar y prevencin de enfermedades.");
        H5 TextoQueOfrecemos3 = new H5(" Plan de beneficios: Adems, nuestros empleados pueden acceder a un plan de" +
                " beneficios que incluye descuentos en productos y servicios de StarPhone y de nuestras empresas asociadas," +
                " as como en eventos y actividades culturales.");
        H5 TextoQueOfrecemos4 = new H5(" Horarios flexibles: Contamos con horarios flexibles y polticas de" +
                " teletrabajo para adaptarnos a las necesidades de nuestros empleados y mejorar su equilibrio entre la" +
                " vida laboral y personal.");
        HorizontalLayout layoutQueEstamosBuscando = new HorizontalLayout();
        H4 Segundo = new H4("2.");
        H4 QueEstamosBuscando = new H4("Qu estamos buscando?");
        H5 TextoQueEstamosBuscando = new H5("Estamos buscando personas comprometidas y proactivas, con una actitud" +
                " positiva y un fuerte sentido de la responsabilidad. Si tienes experiencia en el sector financiero y" +
                " tienes una formacin acadmica en economa, finanzas o carreras similares, podras ser el candidato" +
                " perfecto para nosotros!");
        HorizontalLayout layoutComoSolicitarTrabajo = new HorizontalLayout();
        H4 Tercero = new H4("3.");
        H4 ComoSolicitarTrabajo = new H4("Cmo puedo solicitar un puesto de trabajo?");
        H5 TextoComoSolicitarTrabajo = new H5("Si ests interesado en unirte a nuestro equipo, puedes enviarnos tu" +
                " currculum a travs de nuestro correo \"StarPhone@gmail.com\". Asegrate de incluir una carta de motivacin" +
                " y una descripcin detallada de tus habilidades y experiencia relevantes. Si tu perfil encaja con alguna" +
                " de nuestras vacantes, nos pondremos en contacto contigo para programar una entrevista. Esperamos " +
                "recibir tu candidatura pronto!");
        //ADD
        layoutQueOfrecemos.add(Primero, QueOfrecemos);
        layoutQueEstamosBuscando.add(Segundo, QueEstamosBuscando);
        layoutComoSolicitarTrabajo.add(Tercero, ComoSolicitarTrabajo);
        layoutTextoTrabajaConNosotros.add(Titulo, Bienvenida, TextoBienvenida1, layoutQueOfrecemos, TextoQueOfrecemos, TextoQueOfrecemos1, TextoQueOfrecemos2, TextoQueOfrecemos3, TextoQueOfrecemos4, layoutQueEstamosBuscando, TextoQueEstamosBuscando, layoutComoSolicitarTrabajo, TextoComoSolicitarTrabajo);
        layoutTrabajaConNosotros.add(layoutTextoTrabajaConNosotros, new footer());
        //ADD CLASS NAME
        Titulo.addClassName("Titulo");
        Primero.addClassName("Numero");
        Segundo.addClassName("Numero");
        Tercero.addClassName("Numero");
        QueOfrecemos.addClassName("PreguntaTrabajaConNosotros");
        QueEstamosBuscando.addClassName("PreguntaTrabajaConNosotros");
        ComoSolicitarTrabajo.addClassName("PreguntaTrabajaConNosotros");
        Bienvenida.addClassName("textoSinMargenTrabajaConNosotros");
        TextoBienvenida1.addClassName("textoSinMargenTrabajaConNosotros");
            TextoQueOfrecemos.addClassName("textoTrabajaConNosotros");
            TextoQueOfrecemos1.addClassName("textoTrabajaConNosotrosDobleMargen");
            TextoQueOfrecemos2.addClassName("textoTrabajaConNosotrosDobleMargen");
            TextoQueOfrecemos3.addClassName("textoTrabajaConNosotrosDobleMargen");
            TextoQueOfrecemos4.addClassName("textoTrabajaConNosotrosDobleMargen");
            TextoQueEstamosBuscando.addClassName("textoTrabajaConNosotros");
            TextoComoSolicitarTrabajo.addClassName("textoTrabajaConNosotros");
            layoutTextoTrabajaConNosotros.addClassName("layoutTextoTrabajaConNosotros");
            //ALIGNMENT
            layoutTextoTrabajaConNosotros.setWidth("50%");
            layoutTrabajaConNosotros.expand(layoutTextoTrabajaConNosotros);
            layoutTextoTrabajaConNosotros.setAlignItems(FlexComponent.Alignment.START);
            layoutTrabajaConNosotros.setAlignItems(FlexComponent.Alignment.CENTER);
            layoutTrabajaConNosotros.setSizeFull();
            add(layoutTrabajaConNosotros);
    }
}