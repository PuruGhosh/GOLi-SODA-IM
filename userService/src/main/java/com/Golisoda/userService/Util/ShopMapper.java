package com.Golisoda.userService.Util;

import com.Golisoda.userService.Dto.shopDto;
import com.Golisoda.userService.Models.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShopMapper {

    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);


    Shop toShop(shopDto shopdto);

    shopDto toShopDto(Shop shop);
}

