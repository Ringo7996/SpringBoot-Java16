package com.example.APIUser.service;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.dto.CourseWithPageRecord;
import com.example.APIUser.dto.UpsertCourseRequest;
import com.example.APIUser.entity.Course;
import com.example.APIUser.exception.NotFoundException;
import com.example.APIUser.mapper.CourseMapper;
import com.example.APIUser.repo.AppRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    public AppRepository appRepo;

    @Override
    public CourseWithPageRecord getCourseListWithPage(int pageValue, int pageSizeValue) {
        int currentPage = pageValue;
        int pageSize = pageSizeValue;


        int totalPages;
        if (appRepo.getCourses().size() % pageSizeValue == 0) {
            totalPages = appRepo.getCourses().size() / pageSizeValue;
        } else {
            totalPages = appRepo.getCourses().size() / pageSizeValue + 1;
        }

        int totalItems = appRepo.getCourses().size();
        List<Course> coursePage = new ArrayList<>();

        int indexStart = (pageValue - 1) * pageSize;
        for (int i = 0; i < pageSize; i++) {
            coursePage.add(appRepo.getCourses().get(indexStart));
            indexStart++;
        }

        List<CourseRecord> data = coursePage.stream().map(course -> CourseMapper.toCourseRecord(course, appRepo.getUsers())).collect(Collectors.toList());
        return new CourseWithPageRecord(currentPage, pageSize, totalPages, totalItems, data);
    }

    @Override
    public CourseRecord createCourse(UpsertCourseRequest req) {
        Course newCourse = new Course();
        newCourse.setId(appRepo.getId()+1);
        newCourse.setName(req.getName());
        newCourse.setDescription(req.getDescription());
        newCourse.setType(req.getType());
        newCourse.setTopics(req.getTopics());
        newCourse.setThumbnail(req.getThumbnail());
        newCourse.setUserId(req.getUserId());

        appRepo.getCourses().add(newCourse);

        return CourseMapper.toCourseRecord(newCourse, appRepo.getUsers());
    }

    @Override
    public CourseRecord editCourseById(int id, UpsertCourseRequest req) {
        Course editedCourse = null;
        for (Course c : appRepo.getCourses()) {
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

        return CourseMapper.toCourseRecord(editedCourse, appRepo.getUsers());
    }


    @Override
    public void deleteCourseById(int id) {
        Course deletedCourse = null;
        for (Course c : appRepo.getCourses()) {
            if (c.getId() == id) {
                deletedCourse = c;
            }
        }

        if (deletedCourse == null) {
            throw new NotFoundException("User" + id + "not found");
        } else {
            appRepo.getCourses().remove(deletedCourse);
        }
    }
}


