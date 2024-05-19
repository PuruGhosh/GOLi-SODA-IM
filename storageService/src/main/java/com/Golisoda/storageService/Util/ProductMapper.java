package com.Golisoda.storageService.Util;

import com.Golisoda.storageService.Dto.ProductDto;
import com.Golisoda.storageService.Entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    Product toProduct(ProductDto productDto);

    ProductDto toProductDto(Product product);
}

