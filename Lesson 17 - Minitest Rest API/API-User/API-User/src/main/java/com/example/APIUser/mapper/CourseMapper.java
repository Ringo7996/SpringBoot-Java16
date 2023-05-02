package com.example.APIUser.mapper;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.entity.Course;
import com.example.APIUser.entity.User;
import com.example.APIUser.exception.NotFoundException;

import java.util.List;

public class CourseMapper {
    public static CourseRecord toCourseRecord(Course course, List<User> users) {
        User user = null;
        for (User u : users) {
            if (u.getId() == course.getUserId()) {
                user = u;
                break;
            }
        }


        if (user == null) {
            throw new NotFoundException("User" + course.getUserId() + "not found");
        }

        return new CourseRecord(course.getId(), course.getName(), course.getDescription(), course.getType(), course.getTopics(), course.getThumbnail(), user);
    }
}
