package com.Golisoda.storageService.Util;

import com.Golisoda.storageService.Dto.StockDto;
import com.Golisoda.storageService.Entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    @Mapping(target = "product.productID", source ="productId" )
    @Mapping(target = "batch.batchID", source = "batchId")
    Stock toStock(StockDto stockDto);
    @Mappings({
            @Mapping(source = "batch.batchID", target = "batchId"),
            @Mapping(source = "product.productID", target = "productId"),
            @Mapping(source = "stockId", target = "stockId"),
            @Mapping(source = "warehouseId", target = "warehouseId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "modifiedDate", target = "lastModified")
    })
    StockDto toStockDto(Stock stock);
}
