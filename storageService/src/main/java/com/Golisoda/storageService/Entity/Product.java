package com.Golisoda.storageService.Entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @Column(length = 255)
    private String productID;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String ingredients;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Batch> batches;
}

