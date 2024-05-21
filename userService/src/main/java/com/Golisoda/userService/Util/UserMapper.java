package com.Golisoda.userService.Util;

import com.Golisoda.userService.Dto.userDto;
import com.Golisoda.userService.Models.UserdB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    @Mapping(source = "address", target = "address")
    UserdB toUser(userDto userdto);

    @Mapping(source = "address", target = "address")
    userDto toUserDto(UserdB user);
}

