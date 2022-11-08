package com.mobileconnection;

import com.sun.mail.util.logging.MailHandler;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

import java.util.Properties;
import java.util.logging.*;

public class MyLogger {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static void setup() {
        LogManager.getLogManager().reset();
        logger.setLevel(java.util.logging.Level.ALL);

        try {
            FileHandler fileHandler = new FileHandler("log.log", true);
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "File logger not working.", e);
        }

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.transport.protocol", "smtp");
        // authenticator
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("bohdanshylo007@gmail.com", "gvnecfujdjzhgyjh");
            }
        };

        MailHandler h = new MailHandler(properties);
        h.setAuthenticator(authenticator);
        h.setLevel(Level.SEVERE);
        logger.addHandler(h);
    }
}
