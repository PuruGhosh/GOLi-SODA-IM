package com.Golisoda.userService.Util;

import com.Golisoda.userService.Dto.addressDto;
import com.Golisoda.userService.Models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);


    @Mapping(source = "address_line1", target = "address_line1")
    Address toAddress(addressDto addressDto);

    @Mapping(source = "address_line1", target = "address_line1")
    addressDto toAddressDto(Address address);
}

