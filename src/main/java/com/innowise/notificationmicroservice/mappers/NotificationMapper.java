package com.innowise.notificationmicroservice.mappers;

import avro.NotificationRequest;
import com.innowise.notificationmicroservice.entity.NotificationEntity;
import com.innowise.notificationmicroservice.service.impl.SendEmailServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = SendEmailServiceImpl.class)
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    NotificationEntity notificationRequestToNotificationEntity(NotificationRequest notification);
    NotificationRequest notificationEntityToNotification(NotificationEntity notificationEntity);
    List<NotificationRequest> toNotificationRequestsList(List<NotificationEntity> notificationEntities);
}
