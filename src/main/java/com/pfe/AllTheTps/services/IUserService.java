package com.pfe.AllTheTps.services;

import com.pfe.AllTheTps.DTOs.UserDto;

import java.util.List;
public interface IUserService {
    UserDto addUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
    List<UserDto> selectUsers();
}