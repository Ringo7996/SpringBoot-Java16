package com.example.JpaRelation.controller;


import com.example.JpaRelation.service.FileServerService;
import com.example.JpaRelation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {
    @Autowired
    private FileServerService fileServerService;

    private @Autowired
    UserService userService;


    @GetMapping("/users")
    public String getUserPage(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/{id}/files")
    public String getFilesPage(Model model, @PathVariable Integer id) {
        model.addAttribute("files",fileServerService.getFilesOfUser(id));
        model.addAttribute("userId",id);
        return "files";
    }
}
