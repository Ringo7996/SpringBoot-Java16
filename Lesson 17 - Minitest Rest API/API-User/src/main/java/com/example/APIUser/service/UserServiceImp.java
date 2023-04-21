package com.example.APIUser.service;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.entity.Course;
import com.example.APIUser.entity.User;
import com.example.APIUser.exception.NotFoundException;
import com.example.APIUser.mapper.CourseMapper;
import com.example.APIUser.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    public Repository repo;


    private static int id = 1;
    private static List<User> users = new ArrayList<User>();
    private static List<Course> courses = new ArrayList<Course>();

    static {
        users.add(new User(1, "Nguyen Van A", "a@gmail.com", "0987654321", ""));
        users.add(new User(2, "Nguyen Van B", "b@gmail.com", "0987654321", ""));
        users.add(new User(3, "Nguyen Van C", "c@gmail.com", "0987654321", ""));
        users.add(new User(4, "Nguyen Van D", "d@gmail.com", "0987654321", ""));

        List<String> topics1 = new ArrayList<>(Arrays.asList("java", "backend"));
        List<String> topics2 = new ArrayList<>(Arrays.asList("php", "backend"));
        List<String> topics3 = new ArrayList<>(Arrays.asList("php", "backend"));
        List<String> topics4 = new ArrayList<>(Arrays.asList("react", "frontend"));
        courses.add(new Course(id++, "Khóa học 1", "Mo ta", "online", topics1, "thumbnail", 1));
        courses.add(new Course(id++, "Khóa học 2", "Mo ta 2", "online", topics2, "thumbnail", 2));
        courses.add(new Course(id++, "Khóa học 3", "Mo ta 3", "offline", topics3, "thumbnail", 3));
        courses.add(new Course(id++, "Khóa học 4", "Mo ta 4", "offline", topics4, "thumbnail", 1));
    }


    @Override
    public CourseRecord getCourseById(int id) {
        Course course = null;
        for (Course c : courses) {
            if (c.getId() == id) {
                course = c;
            }
        }

        if (course == null) {
            throw new NotFoundException("User" + id + "not found");
        }

        return CourseMapper.toCourseRecord(course, users);
    }

    @Override
    public List<CourseRecord> getCourseList(String typeValue, String nameValue, String topicValue) {
        List<Course> FilterCourses = courses.stream().filter(course -> course.getType().equals(typeValue) && course.getName().contains(nameValue) && course.getTopics().contains(topicValue)).collect(Collectors.toList());

        return FilterCourses.stream().map(course -> CourseMapper.toCourseRecord(course, users)).collect(Collectors.toList());
    }
}
