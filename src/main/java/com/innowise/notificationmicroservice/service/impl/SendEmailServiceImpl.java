package com.innowise.notificationmicroservice.service.impl;

import avro.Notification;
import com.innowise.notificationmicroservice.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendEmailServiceImpl implements SendEmailService {

    private final JavaMailSender javaMailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    public void sendEmail(Notification notification) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(notification.getEmailTo().toString());
        message.setSubject(notification.getSubject().toString());
        message.setText(notification.getBody().toString());
        message.setFrom(emailFrom);

        javaMailSender.send(message);
    }

    public String map(CharSequence charSequence) {
        return charSequence.toString();
    }
}
