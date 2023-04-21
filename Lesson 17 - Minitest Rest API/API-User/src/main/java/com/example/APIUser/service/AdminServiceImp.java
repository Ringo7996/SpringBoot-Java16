package com.example.APIUser.service;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.dto.CourseWithPageRecord;
import com.example.APIUser.dto.UpsertCourseRequest;
import com.example.APIUser.entity.Course;
import com.example.APIUser.entity.User;
import com.example.APIUser.exception.NotFoundException;
import com.example.APIUser.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImp implements AdminService {
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
        courses.add(new Course(id++, "Khóa học 5", "Mo ta", "offline", topics4, "thumbnail", 4));
        courses.add(new Course(id++, "Khóa học 6", "Mo ta 2", "online", topics3, "thumbnail", 2));
        courses.add(new Course(id++, "Khóa học 7", "Mo ta 3", "offline", topics2, "thumbnail", 3));
        courses.add(new Course(id++, "Khóa học 8", "Mo ta 4", "offline", topics1, "thumbnail", 1));
        courses.add(new Course(id++, "Khóa học 9", "Mo ta", "online", topics4, "thumbnail", 4));
        courses.add(new Course(id++, "Khóa học 10", "Mo ta 2", "online", topics2, "thumbnail", 2));
        courses.add(new Course(id++, "Khóa học 11", "Mo ta 3", "offline", topics1, "thumbnail", 1));
        courses.add(new Course(id++, "Khóa học 12", "Mo ta 4", "offline", topics2, "thumbnail", 1));
    }


    @Override
    public CourseWithPageRecord getCourseListWithPage(int pageValue, int pageSizeValue) {
        int currentPage = pageValue;
        int pageSize = pageSizeValue;

        int totalPages;
        if (courses.size() % pageSizeValue == 0) {
            totalPages = courses.size() / pageSizeValue;
        } else {
            totalPages = courses.size() / pageSizeValue + 1;
        }

        int totalItems = courses.size();
        List<Course> coursePage = new ArrayList<>();

        int indexStart = (pageValue - 1) * pageSize;
        for (int i = 0; i < pageSize; i++) {
            coursePage.add(courses.get(indexStart));
            indexStart++;
        }

        List<CourseRecord> data = coursePage.stream().map(course -> CourseMapper.toCourseRecord(course, users)).collect(Collectors.toList());
        return new CourseWithPageRecord(currentPage, pageSize, totalPages, totalItems, data);
    }

    @Override
    public CourseRecord createCourse(UpsertCourseRequest req) {
        Course newCourse = new Course();
        newCourse.setId(id++);
        newCourse.setName(req.getName());
        newCourse.setDescription(req.getDescription());
        newCourse.setType(req.getType());
        newCourse.setTopics(req.getTopics());
        newCourse.setThumbnail(req.getThumbnail());
        newCourse.setUserId(req.getUserId());

        courses.add(newCourse);

        return CourseMapper.toCourseRecord(newCourse, users);
    }

    @Override
    public CourseRecord editCourseById(int id, UpsertCourseRequest req) {
        Course editedCourse = null;
        for (Course c : courses) {
            if (c.getId() == id) {
                editedCourse = c;
            }
        }

        if (editedCourse == null) {
            throw new NotFoundException("User" + id + "not found");
        }

        editedCourse.setName(req.getName());
        editedCourse.setDescription(req.getDescription());
        editedCourse.setType(req.getType());
        editedCourse.setTopics(req.getTopics());
        editedCourse.setThumbnail(req.getThumbnail());
        editedCourse.setUserId(req.getUserId());

        return CourseMapper.toCourseRecord(editedCourse, users);
    }



    @Override
    public void deleteCourseById(int id) {
        Course deletedCourse = null;
        for (Course c : courses) {
            if (c.getId() == id) {
                deletedCourse = c;
            }
        }

        if (deletedCourse == null) {
            throw new NotFoundException("User" + id + "not found");
        } else {
            courses.remove(deletedCourse);
        }
    }
}


