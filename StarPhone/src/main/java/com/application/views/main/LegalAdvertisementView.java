package com.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.application.views.main.layouts.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@CssImport("./styles/styles.css")
@PageTitle("Aviso Legal")
@Route(value = "avisolegal")
public class LegalAdvertisementView extends VerticalLayout {
    
    header h;
    navBar m;
    VerticalLayout centerDiv, leftIntoCenterDiv, centerIntoCenterDiv, rightIntoCenterDiv;
    footer f;
    HorizontalLayout intoCenterDiv;
    Button butcustomer, butnocustomer;

    public LegalAdvertisementView() {
          VerticalLayout layoutAvisoLegal = new VerticalLayout();
        VerticalLayout layoutTextoAvisoLegal = new VerticalLayout();
        H1 Titulo = new H1("Aviso Legal");
        H3 CondicionesGeneralesUso = new H3("CONDICIONES GENERALES DE USO");
        H5 TextoCondGenUso = new H5("Este sitio web (en adelante, \"el Sitio\") es propiedad de StarPhone, S.A. (en adelante," +
                " \"StarPhone\"). El acceso y uso del Sitio estn sujetos a las siguientes condiciones de uso y a todas las " +
                "leyes y regulaciones aplicables. Al acceder y utilizar el Sitio, usted acepta estas condiciones de uso " +
                "sin modificaciones. Si no est de acuerdo con estas condiciones de uso, no debe utilizar el Sitio.");
        H3 ResponsabilidadGarantia = new H3("RESPONSABILIDAD Y GARANTA DE GRUPO StarPhone");
        H5 TextoRespGar1 = new H5("StarPhone se reserva el derecho de modificar estas condiciones de uso en cualquier momento y " +
                "sin previo aviso. Su uso continuado del Sitio despus de la publicacin de cualquier modificacin de " +
                "estas condiciones de uso constituir su aceptacin de dichas modificaciones.");
        H5 TextoRespGar2 = new H5("El contenido del Sitio se proporciona \"tal cual\" sin garanta de ningn tipo, " +
                "ya sea expresa o implcita. StarPhone no garantiza la exactitud, confiabilidad o integridad de cualquier " +
                "informacin, texto, grficos, enlaces u otros elementos contenidos en el Sitio. StarPhone no ser " +
                "responsable de ningn error u omisin en el contenido del Sitio.");
        H5 TextoRespGar3 = new H5("El uso del Sitio y del contenido del mismo es bajo su propia responsabilidad. " +
                "StarPhone no ser responsable de ningn dao o perjuicio de cualquier tipo derivado del uso o la " +
                "imposibilidad de uso del Sitio o de cualquier sitio web vinculado a l.");
        H5 TextoRespGar4 = new H5("Este Sitio puede contener enlaces a sitios web de terceros. Estos enlaces se " +
                "proporcionan nicamente como una conveniencia y no implican la aprobacin por parte de StarPhone de los " +
                "sitios web de terceros ni una responsabilidad por el contenido de dichos sitios web. StarPhone no controla " +
                "ni es responsable del contenido de los sitios web de terceros. El uso de cualquier sitio web de " +
                "terceros es bajo su propia responsabilidad.");
        H5 TextoRespGar5 = new H5("StarPhone se reserva el derecho de denegar el acceso al Sitio en cualquier momento " +
                "y sin previo aviso.");
        H3 PropiedadIndustrialIntelectual = new H3("PROPIEDAD INDUSTRIAL E INTELECTUAL");
        H5 TextoPropIndInt = new H5("El Sitio y todo el contenido, incluyendo texto, grficos, imgenes y software, son " +
                "propiedad de StarPhone o de sus proveedores de contenido y estn protegidos por las leyes de propiedad " +
                "intelectual de Espaa y otras leyes y tratados internacionales. El contenido del Sitio no puede ser " +
                "copiado, reproducido, distribuido, transmitido, exhibido, publicado ni utilizado de ninguna otra forma " +
                "sin el consentimiento previo por escrito de StarPhone.");
        H3 LegislacionAplicable = new H3("LEGISLACIN APLICABLE");
        H5 TextoLegApli = new H5("Las presentes condiciones generales se regirn por la legislacin espaola.");
        H3 InformacionProteccionDatos = new H3("INFORMACIN SOBRE PROTECCIN DE DATOS");
        H5 TextoInfProtDat1 = new H5("StarPhone se compromete a proteger la privacidad y la seguridad de sus clientes y a cumplir" +
                " con todas las leyes y regulaciones aplicables en materia de proteccin de datos personales.");
        H5 TextoInfProtDat2 = new H5("StarPhone recopila y procesa ciertos datos personales de sus clientes con el fin " +
                "de proporcionar servicios financieros y realizar actividades comerciales. Estos datos pueden incluir " +
                "nombre, direccin, nmero de identificacin, informacin de contacto y datos financieros. StarPhone " +
                "tambin puede recopilar y procesar datos personales de otras fuentes, como agencias de informes " +
                "crediticios y otras entidades financieras.");
        H5 TextoInfProtDat3 = new H5("StarPhone solo utiliza los datos personales de sus clientes de acuerdo con los propsitos " +
                "para los que se han recopilado y en conformidad con las leyes y regulaciones aplicables. StarPhone tambin toma " +
                "medidas de seguridad razonables para proteger los datos personales de sus clientes contra el uso no autorizado," +
                " la prdida, el acceso no autorizado, la divulgacin, la alteracin y la destruccin.");
        H5 TextoInfProtDat4 = new H5("Los clientes de StarPhone tienen ciertos derechos en relacin con sus datos personales, " +
                "como el derecho a acceder a sus datos, solicitar una copia de los mismos, solicitar su rectificacin o " +
                "eliminacin y oponerse al tratamiento de sus datos. Los clientes tambin tienen el derecho a presentar una " +
                "queja ante la autoridad de proteccin de datos competente si creen que StarPhone ha violado sus derechos en " +
                "materia de proteccin de datos.");
        //ADD
        layoutTextoAvisoLegal.add(Titulo, CondicionesGeneralesUso, TextoCondGenUso, ResponsabilidadGarantia, TextoRespGar1, TextoRespGar2, TextoRespGar3, TextoRespGar4, TextoRespGar5, PropiedadIndustrialIntelectual, TextoPropIndInt, LegislacionAplicable, TextoLegApli, InformacionProteccionDatos, TextoInfProtDat1, TextoInfProtDat2, TextoInfProtDat3, TextoInfProtDat4);
        layoutAvisoLegal.add(layoutTextoAvisoLegal, new footer());
        //ADD CLASS NAME
        Titulo.addClassName("Titulo");
        layoutTextoAvisoLegal.addClassName("layoutTextoAvisoLegal");
        TextoCondGenUso.addClassName("texto");
        ResponsabilidadGarantia.addClassName("texto");
        TextoRespGar1.addClassName("texto");
        TextoRespGar2.addClassName("texto");
        TextoRespGar3.addClassName("texto");
        TextoRespGar4.addClassName("texto");
        TextoRespGar5.addClassName("texto");
        TextoPropIndInt.addClassName("texto");
        TextoLegApli.addClassName("texto");
        TextoInfProtDat1.addClassName("texto");
        TextoInfProtDat2.addClassName("texto");
        TextoInfProtDat3.addClassName("texto");
        TextoInfProtDat4.addClassName("texto");
        //ALIGNMENT
        layoutTextoAvisoLegal.setWidth("50%");
        layoutAvisoLegal.expand(layoutTextoAvisoLegal);
        layoutTextoAvisoLegal.setAlignItems(Alignment.START);
        layoutAvisoLegal.setAlignItems(Alignment.CENTER);
        layoutAvisoLegal.setSizeFull();
        add(layoutAvisoLegal);
    }

}
