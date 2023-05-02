package com.example.APIUser.service;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    CourseRecord getCourseById(int id);

    List<CourseRecord> getCourseList(String typeValue, String nameValue, String topicValue);

}
