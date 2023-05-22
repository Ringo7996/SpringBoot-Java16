package vn.techmaster.hellojpa.controller;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.hellojpa.dto.UserDTO;
import vn.techmaster.hellojpa.entity.User;
import vn.techmaster.hellojpa.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public List<User> testCreateUserWithTransaction() {
        userService.testTransaction();
        return userService.getAllUsers();
    }

//    @GetMapping
//    public List<UserDTO> getUsersByPageAndSort(@RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize, @RequestParam(name = "currentPage",defaultValue = "0") Integer currentPage, @RequestParam(name = "sortBy",defaultValue = "id") String sortBy){
//       return userService.getUserByPageAndSort(pageSize,currentPage,sortBy);
//    }

    @GetMapping
    public List<UserDTO> getUsersByPageAndSort(Pageable pageable){
        return userService.getUserByPageAndSortPageable(pageable);
    }

    @GetMapping
    public List<UserDTO> filterByNameAndEmailContains(@RequestParam(name = "nameOrEmail") String nameOrEmail,Pageable pageable){
        return userService.filterByNameAndEmailContains(nameOrEmail, pageable);
    }




}
