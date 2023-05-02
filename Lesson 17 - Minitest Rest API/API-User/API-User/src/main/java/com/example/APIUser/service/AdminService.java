package com.example.APIUser.service;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.dto.CourseWithPageRecord;
import com.example.APIUser.dto.UpsertCourseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    CourseWithPageRecord getCourseListWithPage(int pageValue, int pageSizeValue);

    CourseRecord createCourse(UpsertCourseRequest req);

    CourseRecord editCourseById(int id, UpsertCourseRequest req);

    void deleteCourseById(int id);
}
