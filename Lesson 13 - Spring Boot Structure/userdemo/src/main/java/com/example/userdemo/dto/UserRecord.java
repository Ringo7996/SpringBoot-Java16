package com.example.userdemo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserRecord(int id, String name,
                         @NotNull String email,
                         @NotEmpty String phone,
                         String avatar) {
}
