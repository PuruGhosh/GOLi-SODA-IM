package com.Golisoda.storageService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {
    private String batchID;
    private String productID; // To reference the associated product

    private Long quantity;

    private Long itemLeft;

    private String flavour;

    private String essence;

    private String ingredients;

    private LocalDateTime manufactureDate;

    private LocalDateTime expiryDate;
}
