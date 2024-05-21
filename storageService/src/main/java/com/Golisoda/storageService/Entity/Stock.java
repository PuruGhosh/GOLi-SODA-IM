package com.Golisoda.storageService.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
public class Stock {
    @Id
    private String stockId;
    @Column(length = 255, nullable = false)
    private String warehouseId;

    @ManyToOne
    @JoinColumn(name = "batchId", nullable = false)
    private Batch batch;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    private long quantity;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;
}
