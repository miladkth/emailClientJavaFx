package org.example.email.controller;

import org.example.email.model.EmailAccount;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    public static void sendMail(EmailAccount account, String to, String subject, String body) {
        Session session = Session.getInstance(account.getProperties());

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(account.getAddress()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            if (Boolean.parseBoolean(account.getProperties().getProperty("mail.smtp.auth"))) {
                Transport.send(message, account.getAddress(), account.getPassword());
            } else {
                Transport.send(message); // för MailHog
            }

            System.out.println("✅ Mejlet skickades!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
