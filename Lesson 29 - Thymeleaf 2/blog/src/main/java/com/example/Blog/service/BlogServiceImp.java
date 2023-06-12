package com.example.Blog.service;

import com.example.Blog.entity.Blog;
import com.example.Blog.entity.Category;
import com.example.Blog.entity.User;
import com.example.Blog.repository.BlogRepository;
import com.example.Blog.repository.CategoryRepository;
import com.example.Blog.repository.UserRepository;
import com.example.Blog.request.UpsertBlogRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Blog> getAllPublicBlogs(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        return blogRepository.findByStatusOrderByPublishedAtDesc(true, pageRequest);
    }

    @Override
    public List<Blog> searchBlogs(String term) {
        return blogRepository.findByStatusAndTitleContainsIgnoreCase(true, term);
    }


    @Override
    public Blog getBlogByIdAndSlug(Integer id, String slug) {
        return blogRepository.findByIdAndSlugAndStatus(id, slug, true);
    }

    @Override
    public Page<Blog> getAllPost(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        return blogRepository.findAll(pageRequest);
    }

    @Override
    public List<Blog> getBlogsOfUser(Integer userId) {

        return blogRepository.findByUser_Id(userId);
    }

    @Override
    public Blog upsertBlog(UpsertBlogRequest request) {
        List<Category> categoryList = categoryRepository.findAllById(request.getCategoryIds());


        String slug = request.getTitle().replace(" ", "-");


        Blog newBlog = Blog.builder().title(request.getTitle()).description(request.getDescription())
                .content(request.getContent()).thumbnail(request.getThumbnail()).status(request.getStatus())
                .categories(categoryList).slug(slug).build();

        blogRepository.save(newBlog);

        return newBlog;
    }

    @Override
    public Blog updateBlog(UpsertBlogRequest request, Integer id) {
        List<Category> categoryList = categoryRepository.findAllById(request.getCategoryIds());
        Blog blog2find = blogRepository.findById(id).orElseThrow(RuntimeException::new);

        blog2find.setTitle(request.getTitle());
        blog2find.setDescription(request.getDescription());
        blog2find.setContent(request.getContent());
        blog2find.setThumbnail(request.getThumbnail());
        blog2find.setStatus(request.getStatus());
        blog2find.setCategories(categoryList);
        blogRepository.save(blog2find);

        return blog2find;
    }

    @Override
    public void deleteBlog(Integer id) {
        Blog blog2find = blogRepository.findById(id).orElseThrow(RuntimeException::new);
        blogRepository.delete(blog2find);
    }

    @Override
    public Blog getBlogById(Integer blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        return blog.orElse(null);
    }
}

