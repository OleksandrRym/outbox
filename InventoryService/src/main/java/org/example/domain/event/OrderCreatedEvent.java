package org.example.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID id,
        String product,
        int quantity,
        double price,
        String status,
        LocalDateTime createdAt
) {}