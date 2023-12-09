package com.innowise.notificationmicroservice.service;

import avro.Notification;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface NotificationService {
    List<Notification> getNotifications(Integer offset, Integer limit);
    Notification getNotificationById(Long id) throws Exception;
}
