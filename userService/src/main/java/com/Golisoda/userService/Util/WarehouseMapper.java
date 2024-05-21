package com.Golisoda.userService.Util;

import com.Golisoda.userService.Dto.warehouseDto;
import com.Golisoda.userService.Models.WareHouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WarehouseMapper {

    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);


    @Mapping(source = "address", target = "address")
    WareHouse toWarehouse(warehouseDto warehousedto);

    @Mapping(source = "address", target = "address")
    warehouseDto toWarehouseDto(WareHouse warehouse);
}

