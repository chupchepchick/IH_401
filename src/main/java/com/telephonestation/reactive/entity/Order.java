package com.telephonestation.reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Long clientId;
    private List<Long> productIds;
    private BigDecimal totalPrice;
    private boolean paid;
    private LocalDateTime createdAt;
}