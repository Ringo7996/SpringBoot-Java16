package com.example.APIUser.service;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.entity.Course;
import com.example.APIUser.exception.NotFoundException;
import com.example.APIUser.mapper.CourseMapper;
import com.example.APIUser.repo.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    public AppRepository appRepo;

    @Override
    public CourseRecord getCourseById(int id) {
        Course course = null;
        for (Course c : appRepo.getCourses()) {
            if (c.getId() == id) {
                course = c;
            }
        }

        if (course == null) {
            throw new NotFoundException("User" + id + "not found");
        }

        return CourseMapper.toCourseRecord(course, appRepo.getUsers());
    }

    @Override
    public List<CourseRecord> getCourseList(String typeValue, String nameValue, String topicValue) {
        List<Course> FilterCourses = appRepo.getCourses().stream().filter(course -> course.getType().equals(typeValue) && course.getName().contains(nameValue) && course.getTopics().contains(topicValue)).collect(Collectors.toList());

        return FilterCourses.stream().map(course -> CourseMapper.toCourseRecord(course, appRepo.getUsers())).collect(Collectors.toList());
    }
}
