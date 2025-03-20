package com.pfe.AllTheTps.DTOs;



import com.pfe.AllTheTps.validations.Password;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    @NotNull(message = " DTO Name cannot be null")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;

    @NotNull(message = " DTO Address cannot be null")
    @Size(max = 255, message = " DTO Address can be a maximum of 255 characters")
    private String address;

    @NotNull(message = " DTO Email cannot be null")
    @Email(message = " DTO Email should be valid")
    private String email;

    @Password
    private String password;
}
