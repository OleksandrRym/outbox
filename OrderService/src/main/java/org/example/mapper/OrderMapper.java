package org.example.mapper;

import org.example.domain.Order;
import org.example.domain.dto.OrderCreateInputDto;
import org.example.domain.dto.OrderCreatedResponseDto;
import org.example.domain.event.OrderCreatedEvent;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderCreateInputDto dto);
    OrderCreatedEvent toEvent(Order order);
    OrderCreatedResponseDto toResponseDto(Order order);
}