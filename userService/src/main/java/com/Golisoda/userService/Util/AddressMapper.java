package com.Golisoda.userService.Util;

import com.Golisoda.userService.Dto.addressDto;
import com.Golisoda.userService.Models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);


    Address toAddress(addressDto addressDto);

    addressDto toAddressDto(Address address);
}

