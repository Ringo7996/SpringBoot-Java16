package com.example.APIUser.mapper;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.entity.Course;
import com.example.APIUser.entity.User;

import java.util.List;

public class CourseMapper {
    public static CourseRecord toCourseRecord(Course course, List<User> users) {
        User user = new User();
        for (User u : users) {
            if (u.getId() == course.getUserId()) {
                user = u;
                break;
            }
        }
        return new CourseRecord(course.getId(), course.getName(), course.getDescription(), course.getType(), course.getTopics(), course.getThumbnail(), user);
    }
}
