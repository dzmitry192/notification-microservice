package com.innowise.notificationmicroservice.service;

import avro.Notification;

public interface SendEmailService {
    void sendEmail(Notification notification);
}
