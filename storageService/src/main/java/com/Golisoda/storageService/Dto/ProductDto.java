package com.Golisoda.storageService.Dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private String productID;
    private String name;

    
    private String description;


    private String category;


    private String ingredients;

}
