package org.example.service;

import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.Order;
import org.example.domain.enums.Status;
import org.example.publisher.OrderEventPublisher;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final OrderEventPublisher publisher;

  @Transactional
  public Order createOrder(Order order) {
    order.setStatus(Status.PENDING);
    Order created = orderRepository.save(order);
    publisher.publish(created);
    return created;
  }

  public Order getOrderByUUID(UUID uuid) {
    return orderRepository
        .findById(uuid)
        .orElseThrow(() -> new RuntimeException("Order not found"));
  }
}
