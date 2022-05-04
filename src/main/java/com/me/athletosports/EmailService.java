package com.me.athletosports;

import com.me.athletosports.pojo.Reservation;
import com.me.athletosports.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;



@Service("mailService")
public class EmailService {

    public void sendEmail(Reservation reservationInfo, User user) {
        String from = "atheltosportsneu@gmail.com";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(user.getEmail());
        message.setSubject("You Booking Was Successful");
        message.setText("Hello " + user.getFirstname() +"!,\nYour booking on following date " +
                reservationInfo.getDate() + ". For " +
                reservationInfo.getSportType() + " has been confirmed. \nThank You!");

        MailServiceConfig.getInstance().getEmailSender().send(message);
    }

}