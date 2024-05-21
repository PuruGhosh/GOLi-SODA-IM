package com.Golisoda.userService.Util;

import com.Golisoda.userService.Dto.shopDto;
import com.Golisoda.userService.Models.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShopMapper {

    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);


    @Mapping(source = "address", target = "address")
    Shop toShop(shopDto shopdto);

    @Mapping(source = "address", target = "address")
    shopDto toShopDto(Shop shop);
}

