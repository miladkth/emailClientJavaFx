package org.example.email.controller;

import org.example.email.model.EmailAccount;

import javax.mail.*;
import java.util.Properties;

public class EmailReceiver {

    public static void receiveInboxMessages(EmailAccount account) {
        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imap");
            props.put("mail.imap.host", "localhost"); // Ex: hMailServer eller annan lokal IMAP-server
            props.put("mail.imap.port", "143");
            props.put("mail.imap.starttls.enable", "false");

            Session session = Session.getInstance(props);
            Store store = session.getStore("imap");
            store.connect(account.getAddress(), account.getPassword());
            account.setStore(store); // Spara kopplingen i kontot

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] messages = inbox.getMessages();

            System.out.println("📥 Antal meddelanden: " + messages.length);
            for (Message message : messages) {
                System.out.println("Från: " + message.getFrom()[0]);
                System.out.println("Ämne: " + message.getSubject());
                System.out.println("-----");
            }

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
