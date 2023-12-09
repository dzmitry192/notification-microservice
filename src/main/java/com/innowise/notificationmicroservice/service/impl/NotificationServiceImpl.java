package com.innowise.notificationmicroservice.service.impl;

import avro.NotificationRequest;
import com.innowise.notificationmicroservice.entity.NotificationEntity;
import com.innowise.notificationmicroservice.mappers.NotificationMapperImpl;
import com.innowise.notificationmicroservice.repository.NotificationRepository;
import com.innowise.notificationmicroservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<NotificationRequest> getNotifications(Integer offset, Integer limit) {
        return NotificationMapperImpl.INSTANCE.toNotificationRequestsList(notificationRepository.findAll(PageRequest.of(offset, limit)).toList());
    }

    @Override
    public NotificationRequest getNotificationById(Long id) throws Exception {
        Optional<NotificationEntity> optionalNotification = notificationRepository.findById(id);
        if(optionalNotification.isEmpty()) {
            throw new Exception("Notification with id = " + id + " not found");
        }
        return NotificationMapperImpl.INSTANCE.notificationEntityToNotification(notificationRepository.findById(id).get());
    }
}
