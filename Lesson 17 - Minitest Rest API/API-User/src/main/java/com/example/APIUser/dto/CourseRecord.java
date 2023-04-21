package com.example.APIUser.dto;

import com.example.APIUser.entity.User;

import java.util.List;

public record CourseRecord(int id, String name, String description, String type, List<String> topics, String thumbnail, User user) {
}


