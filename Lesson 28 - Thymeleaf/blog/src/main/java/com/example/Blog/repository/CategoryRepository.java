package com.example.Blog.repository;

import com.example.Blog.dto.CategoryDto;
import com.example.Blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT new com.example.Blog.dto.CategoryDto(c.id, c.name, COUNT(b.id)) " +
            "FROM Category c JOIN c.blogs b " +
            "WHERE b.status = true " +
            "GROUP BY c.id")
    List<CategoryDto> getAllCategories();

    @Query("SELECT new com.example.Blog.dto.CategoryDto(c.id, c.name, COUNT(b.id)) " +
            "FROM Category c JOIN c.blogs b " +
            "WHERE b.status = true " +
            "GROUP BY c.id " +
            "ORDER BY COUNT(b.id) DESC " +
            "LIMIT 5")
    List<CategoryDto> getTop5Categories();


    Category findByName(String name);
}