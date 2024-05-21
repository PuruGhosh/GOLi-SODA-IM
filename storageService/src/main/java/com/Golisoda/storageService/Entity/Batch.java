package com.Golisoda.storageService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Batch {

    @Id
    @Column(length = 255)
    private String batchID;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    private Long quantity;
    private Long itemLeft;

    @Column(length = 255)
    private String flavour;

    @Column(length = 255)
    private String essence;

    @Column(columnDefinition = "TEXT")
    private String ingredients;

    private LocalDateTime manufactureDate;

    private LocalDateTime expiryDate;

    // Constructors, getters, setters
}

