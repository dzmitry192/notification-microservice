package com.innowise.notificationmicroservice.mappers;

import avro.Notification;
import com.innowise.notificationmicroservice.entity.NotificationEntity;
import com.innowise.notificationmicroservice.service.impl.SendEmailServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = SendEmailServiceImpl.class)
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    NotificationEntity notificationToNotificationEntity(Notification notification);
    Notification notificationEntityToNotification(NotificationEntity notificationEntity);
    List<Notification> toNotificationList(List<NotificationEntity> notificationEntities);
}
