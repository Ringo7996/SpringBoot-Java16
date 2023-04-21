package com.example.APIUser.controller;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.dto.CourseWithPageRecord;
import com.example.APIUser.dto.UpsertCourseRequest;
import com.example.APIUser.repo.Repository;
import com.example.APIUser.service.AdminService;
import com.example.APIUser.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/courses")
@Validated
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;


    //GET /api/v1/admin/courses?page={pageValue}&pageSize={pageSizeValue}
    @GetMapping("")
    public ResponseEntity<?> getCourseListWithPage(@RequestParam(name = "page", required = false) int pageValue, @RequestParam(name = "pageSize", required = false) int pageSizeValue) {
        CourseWithPageRecord courseListWithPage = adminService.getCourseListWithPage(pageValue, pageSizeValue);

        return ResponseEntity.ok(courseListWithPage);
    }


    //POST /api/v1/admin/courses
    @PostMapping("")
    public ResponseEntity<?> createCourse( @Valid @RequestBody UpsertCourseRequest req) {
        return ResponseEntity.ok(adminService.createCourse(req));
    }


    //GET /api/v1/admin/courses/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        CourseRecord courseRecord = userService.getCourseById(id);
        return ResponseEntity.ok(courseRecord);
    }


    //PUT /api/v1/admin/courses/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> editCourseById(@PathVariable int id, @Valid @RequestBody UpsertCourseRequest req) {
        CourseRecord courseRecord = adminService.editCourseById(id, req);
        return ResponseEntity.ok(courseRecord);
    }

    //DELETE /api/v1/admin/courses/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable int id) {
        adminService.deleteCourseById(id);

        return ResponseEntity.ok("");
    }


}
