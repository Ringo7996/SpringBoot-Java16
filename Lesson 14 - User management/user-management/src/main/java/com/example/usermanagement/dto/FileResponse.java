package com.example.usermanagement.dto;

import lombok.Getter;

@Getter
public class FileResponse {
    private String url;
    public FileResponse(String url) {
        this.url = url;
    }
}