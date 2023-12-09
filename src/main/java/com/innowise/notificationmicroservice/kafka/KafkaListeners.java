package com.innowise.notificationmicroservice.kafka;

import avro.Notification;
import avro.UserDetailsResponse;
import com.innowise.notificationmicroservice.service.impl.SendEmailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
@RequiredArgsConstructor
public class KafkaListeners {
    private UserDetailsResponse userDetailsResponse;
    private final SendEmailServiceImpl sendEmailService;
    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    @KafkaListener(topics = "${kafka.topics.user_details_response}", groupId = "user_details_response_id", containerFactory = "listenerContainerFactory")
    public void userDetailsListener(UserDetailsResponse userDetailsResponse) {
        this.userDetailsResponse = userDetailsResponse;
        countDownLatch.countDown();
    }

    @KafkaListener(topics = "${kafka.topics.notification_request}", groupId = "notification_request_id", containerFactory = "listenerContainerFactory")
    public void notificationRequestListener(Notification notification) {
        sendEmailService.sendEmail(notification);
    }

    public UserDetailsResponse waitForUserDetailsResponse() throws InterruptedException {
        countDownLatch.await();
        return userDetailsResponse;
    }
}