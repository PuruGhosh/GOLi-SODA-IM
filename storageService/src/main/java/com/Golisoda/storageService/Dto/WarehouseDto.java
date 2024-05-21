package com.Golisoda.storageService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WarehouseDto {
    private String warehouseId;
    private String name;
    private String addressId;
    private Long capacity;
    private String managerName;
    private String managerPhnNo;
    private String altPhoneNo;
    private String aadhaarNo;
    private String panNo;
    private String emailId;
    private String region;

    // Constructors, Getters, and Setters
}
