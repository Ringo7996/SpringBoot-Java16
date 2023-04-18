package com.example.usermanagement.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;

    @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    private String phone;

    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    private String name;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Size(min = 4, max = 20, message = "Pasword must be between 4 and 20 characters")
    private String password;

    @NotNull(message = "Adress is required")
    @NotEmpty(message = "Adress is required")
    private String address;

    @Valid
    @URL(regexp="(https?:\\/\\/.*\\.(?:png|jpg))", message="Avatar must be an url image")
    private String avatar;

    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    private Date birthday;

}

