package org.example.email.model;

import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {
    private String address;
    private String password;
    private Properties properties;
    private Store store;

    private String smtpHost;
    private int smtpPort;
    private boolean requiresAuthentication;

    public EmailAccount(String address, String password, String smtpHost, int smtpPort, boolean requiresAuthentication) {
        this.address = address;
        this.password = password;
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.requiresAuthentication = requiresAuthentication;

        this.properties = new Properties();
        setupProperties();
    }
    public EmailAccount(String address, String password) {
        this(address,password,"localhost",1025,false);
    }

    private void setupProperties() {
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", String.valueOf(smtpPort));
        properties.put("mail.smtp.auth", String.valueOf(requiresAuthentication));
        properties.put("mail.smtp.starttls.enable", "false"); // För MailHog behövs inte TLS
    }

    public Properties getProperties() {
        return properties;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
