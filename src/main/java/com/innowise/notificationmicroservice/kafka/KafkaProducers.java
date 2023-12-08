package com.innowise.notificationmicroservice.kafka;

import avro.UserDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducers {

    @Value(value = "${kafka.topics.user_details_request}")
    private String topicUserDetailsRequest;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendUserDetailsRequest(UserDetailsRequest userDetailsRequest) {
        kafkaTemplate.send(topicUserDetailsRequest, userDetailsRequest);
    }
}
