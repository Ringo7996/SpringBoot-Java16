package com.example.APIUser.repo;

import com.example.APIUser.entity.Course;
import com.example.APIUser.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Getter
@Setter
@Component
public class Repository {
    public static int id = 1;
    public static List<User> users ;
    public static List<Course> courses;
    public Repository() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Nguyen Van A", "a@gmail.com", "0987654321", ""));
        users.add(new User(2, "Nguyen Van B", "b@gmail.com", "0987654321", ""));
        users.add(new User(3, "Nguyen Van C", "c@gmail.com", "0987654321", ""));
        users.add(new User(4, "Nguyen Van D", "d@gmail.com", "0987654321", ""));
        this.users = users;


        List<Course> courses = new ArrayList<>();
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
        this.courses = courses;
    }

}
