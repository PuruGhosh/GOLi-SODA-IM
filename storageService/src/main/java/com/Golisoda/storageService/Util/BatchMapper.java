package com.Golisoda.storageService.Util;

import com.Golisoda.storageService.Dto.BatchDto;
import com.Golisoda.storageService.Entity.Batch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BatchMapper {
    BatchMapper INSTANCE = Mappers.getMapper(BatchMapper.class);

    @Mapping(target = "product", ignore = true) // Ignore mapping for productID
    Batch toBatch(BatchDto batchDto);
    @Mapping(source = "product.productID", target = "productID")
    BatchDto toBatchDto(Batch batch);
}
