package com.Golisoda.storageService.Dto;

import com.Golisoda.storageService.Constant.EnStockType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnStockDto {
    private String warehouseId;
    private String batchId;
    private Long quantity;
    private EnStockType type;
}
