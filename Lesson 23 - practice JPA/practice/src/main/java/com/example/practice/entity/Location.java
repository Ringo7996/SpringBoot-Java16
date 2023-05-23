package com.example.practice.entity;

import lombok.Data;
import lombok.Getter;

@Getter
public enum Location {
    HANOI("Hà nội"),
    HAIPHONG("Hải phòng"),
    HOCHIMINH("Tp. Hồ Chí Minh"),
    DANANG("Đà Nẵng");

    private String value;

    Location(String value) {
        this.value = value;
    }
}
