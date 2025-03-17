package com.pfe.AllTheTps.Mappers;


import com.pfe.AllTheTps.DTOs.UserDto;
import com.pfe.AllTheTps.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto userDto);
    UserDto toDto(UserEntity userEntity);
}
