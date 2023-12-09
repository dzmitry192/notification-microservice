package com.innowise.notificationmicroservice.service;

import avro.NotificationRequest;

public interface SendEmailService {
    void sendEmail(NotificationRequest notification);
}
