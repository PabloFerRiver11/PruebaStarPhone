/*package com.application.User.Services;

import java.util.Properties;

import jakarta.websocket.Session;
import org.springframework.stereotype.Service;
@Service
public class UserEmailService {
    public static void sendEmail(String destinatario, String asunto, String cuerpo,String imagen) {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        String remitente = "blablabla";  //Para la dirección blablabla@gmail.com
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "miClaveDeGMail");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            //message.setText(cuerpo);
            MimeMultipart multiParte = new MimeMultipart();

            BodyPart texto = new MimeBodyPart();
            texto.setText(cuerpo);
            multiParte.addBodyPart(texto);
            if(imagen!=null) {
                BodyPart adjunto = new MimeBodyPart();
                adjunto.setDataHandler(new DataHandler(new FileDataSource(imagen)));
                adjunto.setFileName(imagen);
                multiParte.addBodyPart(adjunto);
            }
            message.setContent(multiParte);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, "starphone20");//poner contraseña
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
}*/