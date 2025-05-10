package org.example.email.controller;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    public static void sendTestMail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", "1025");
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "false");

        Session session = Session.getInstance(props);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("test@lokalt.se"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("test@lokalt.se"));
            message.setSubject("Test från JavaFX");
            message.setText("Detta är ett testmeddelande från din app!");

            Transport.send(message);
            System.out.println("✅ Mejlet skickades!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
