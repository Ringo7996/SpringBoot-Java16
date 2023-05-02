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
    private String name;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description is required")
    @Size(min = 50)
    private String description;

    @NotNull(message = "Type is required")
    @NotEmpty(message = "Type is required")
    private String type;
    private List<String> topics;
    private String thumbnail;

    @NotNull(message = "userId is required")
    private Integer userId;

}
