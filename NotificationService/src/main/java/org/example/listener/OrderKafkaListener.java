package org.example.listener;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@KafkaListener(topics = "orders", groupId = "notification-service")
public class OrderKafkaListener {

    @KafkaHandler
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("Received order event: " + event.toString());
    }
}