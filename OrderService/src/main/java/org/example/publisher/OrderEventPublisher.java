package org.example.publisher;


import lombok.RequiredArgsConstructor;
import org.example.domain.Order;
import org.example.domain.event.OrderCreatedEvent;
import org.example.mapper.OrderMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventPublisher {
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    private static final String TOPIC = "orders";
    private final OrderMapper orderMapper;

    public void publish(Order order) {
        OrderCreatedEvent event = orderMapper.toEvent(order);
        kafkaTemplate.send(TOPIC, event);
    }
}