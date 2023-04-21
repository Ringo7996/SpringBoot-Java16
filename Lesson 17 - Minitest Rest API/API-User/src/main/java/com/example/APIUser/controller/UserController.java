package com.example.APIUser.controller;

import com.example.APIUser.dto.CourseRecord;
import com.example.APIUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        CourseRecord courseRecord = userService.getCourseById(id);
        return ResponseEntity.ok(courseRecord);
    }

    @GetMapping("")
    public ResponseEntity<?> getCourseList(@RequestParam(name = "type", required = false) String typeValue, @RequestParam(name = "name", required = false) String nameValue, @RequestParam(name = "topic", required = false) String topicValue) {
        List<CourseRecord> courseList = userService.getCourseList(typeValue, nameValue, topicValue);
        return ResponseEntity.ok(courseList);
    }


}
