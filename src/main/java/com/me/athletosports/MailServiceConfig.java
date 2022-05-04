package com.me.athletosports;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailServiceConfig  {

    private static MailServiceConfig sharedConfig;
    private JavaMailSenderImpl sender = new JavaMailSenderImpl();


    private MailServiceConfig() {
        sender.setPort(2525);
        sender.setHost("smtp.mailtrap.io");
        sender.setPassword("2a230b4d18d3f5");
        sender.setUsername("2e71a926acb96a");
    }

    public static MailServiceConfig getInstance() {
        if (sharedConfig == null) {
            sharedConfig = new MailServiceConfig();
            return sharedConfig;
        }
        return sharedConfig;
    }

    public JavaMailSender getEmailSender() {
        return sender;
    }
}

