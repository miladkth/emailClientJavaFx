package org.example.email.controller.service;

import org.example.email.EmailManager;
import org.example.email.controller.EmailLoginResult;
import org.example.email.model.EmailAccount;

import javax.mail.*;
import java.util.Locale;
//import java.net.Authenticator;
//import java.net.PasswordAuthentication;


public class LoginService {
    EmailAccount emailAccount;
    EmailManager emailManager;

    public LoginService(EmailAccount emailAccount, EmailManager emailManager) {
        this.emailAccount = emailAccount;
        this.emailManager = emailManager;
    }

    public EmailLoginResult login() {
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAccount.getAddress(), emailAccount.getPassword());
            }
        };

        try {
            Session session = Session.getInstance(emailAccount.getProperties(), authenticator);
            Store store = session.getStore("imaps");
            store.connect(emailAccount.getProperties().getProperty("incomingHost"),
                    emailAccount.getAddress(),
                    emailAccount.getPassword());
            emailAccount.setStore(store);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_NETWORK;
        } catch (AuthenticationFailedException e) {
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_CREDENTIALS;
        } catch (MessagingException e) {
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_UNEXPECTED_ERROR;
        } catch (Exception e) {
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_UNEXPECTED_ERROR;
        }
            return EmailLoginResult.SUCCESS;
    }
}


