package org.example.domain.dto;

import java.time.LocalDateTime;

public record OrderCreatedResponseDto (String product, int quantity, double price, LocalDateTime createdAt) {}
