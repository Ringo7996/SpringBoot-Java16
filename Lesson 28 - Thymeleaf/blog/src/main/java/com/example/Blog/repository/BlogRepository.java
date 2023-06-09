package com.example.Blog.repository;

import com.example.Blog.entity.Blog;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findByStatusOrderByPublishedAtDesc(Boolean status, PageRequest pageRequest);

    List<Blog> findByStatusAndTitleContainsIgnoreCase(Boolean status, String term);

    List<Blog> findByStatusIsTrueAndTitleContainsIgnoreCase(String term);
    Blog findByIdAndSlugAndStatus(Integer id, String slug, Boolean status);
}