package com.example.Blog.controller;

import com.example.Blog.entity.Category;
import com.example.Blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin/users")
//@PreAuthorize("hasRole('ADMIN')")
public class WAdminUserController {


        @GetMapping("/index")
        public String getAllCategories(){

            return "/admin/user/user-create";

    }

}
