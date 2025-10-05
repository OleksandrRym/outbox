package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Order;
import org.example.domain.dto.OrderCreateInputDto;
import org.example.domain.dto.OrderCreatedResponseDto;
import org.example.service.OrderService;
import org.example.mapper.OrderMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<OrderCreatedResponseDto> createOrder(@RequestBody OrderCreateInputDto orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        Order created =  orderService.createOrder(order);
        return ResponseEntity.ok(orderMapper.toResponseDto(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderByUUID(@PathVariable UUID id){
        Order order = orderService.getOrderByUUID(id);
        return ResponseEntity.ok(order);
    }
}