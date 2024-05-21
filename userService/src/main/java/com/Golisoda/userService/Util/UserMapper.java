package com.Golisoda.userService.Util;

import com.Golisoda.userService.Dto.userDto;
import com.Golisoda.userService.Models.UserdB;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserdB toUser(userDto userdto);

    userDto toUserDto(UserdB user);
}

