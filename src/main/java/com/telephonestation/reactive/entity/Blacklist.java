package com.telephonestation.reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blacklist {
    private Long id;
    private Long clientId;
    private Long adminId;
    private String reason;
    private LocalDateTime addedAt;
}