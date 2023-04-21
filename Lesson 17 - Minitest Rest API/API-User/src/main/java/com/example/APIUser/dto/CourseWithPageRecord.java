package com.example.APIUser.dto;

import com.example.APIUser.entity.User;

import java.util.List;

public record CourseWithPageRecord(int currentPage, int pageSize, int totalPages, int totalItems, List<CourseRecord> data)  {
}
