package com.innowise.notificationmicroservice.service;

import avro.NotificationRequest;

import java.util.List;

public interface NotificationService {
    List<NotificationRequest> getNotifications(Integer offset, Integer limit);
    NotificationRequest getNotificationById(Long id) throws Exception;
}
