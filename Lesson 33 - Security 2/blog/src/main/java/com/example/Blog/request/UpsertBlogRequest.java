package com.example.Blog.request;

import lombok.Getter;

import java.util.List;

@Getter
public class UpsertBlogRequest {
    private String title;
    private String description;
    private String content;
    private String thumbnail;
    private Boolean status;
    private List<Integer> categoryIds; // Danh sách id của các category áp dụng
}
