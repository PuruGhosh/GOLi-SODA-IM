package com.Golisoda.storageService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
    private String stockId;
    private String warehouseId;
    private String batchId;
    private String productId;
    private Long quantity;
    private LocalDateTime createDate;
    private LocalDateTime lastModified;
}
