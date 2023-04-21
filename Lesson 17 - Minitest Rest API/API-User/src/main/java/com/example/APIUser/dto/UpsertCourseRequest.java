package com.example.APIUser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.validation.constraints.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpsertCourseRequest {
    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    String name;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description is required")
    @Size(min = 50)
    String description;

    @NotNull(message = "Type is required")
    @NotEmpty(message = "Type is required")
    String type;
    List<String> topics;
    String thumbnail;

    @NotNull(message = "userId is required")
    @NotEmpty(message = "userId is required")
    int userId;

}
