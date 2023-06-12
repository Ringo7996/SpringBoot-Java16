package com.example.Blog.service;

import com.example.Blog.dto.CategoryDto;
import com.example.Blog.entity.Blog;
import com.example.Blog.entity.Category;
import com.example.Blog.repository.CategoryRepository;
import com.example.Blog.request.UpsertCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public List<CategoryDto> getTop5Categories() {
        return categoryRepository.getTop5Categories();
    }

    @Override
    public List<Blog> getBlogsByCategory(String name) {
        Category category = categoryRepository.findByName(name);
        List<Blog> publicBlogList = new ArrayList<>();

        for (Blog b : category.getBlogs()) {
            if (b.getStatus()) {
                publicBlogList.add(b);
            }
        }

        return publicBlogList;
    }

    @Override
    public CategoryDto upsertCategory(UpsertCategoryRequest request) {
        Category category2find = categoryRepository.findByName(request.getName());

        if (category2find != null){
            throw new RuntimeException();
        }

        Category category2save = Category.builder().name(request.getName()).build();
        categoryRepository.save(category2save);
        return CategoryDto.builder().id(category2save.getId()).name(category2save.getName()).build();
    }

    @Override
    public CategoryDto updateCategory(UpsertCategoryRequest request, Integer id) {
        if(categoryRepository.findByName(request.getName()) != null){
            throw new RuntimeException("name is already exist");
        }

        Optional<Category> category2find = categoryRepository.findById(id);
        if (!category2find.isPresent()){
           throw new RuntimeException("id not found");
        }
        Category category2update = category2find.get();

        category2update.setName(request.getName());
        categoryRepository.save(category2update);

        return categoryRepository.getCategoryDTOById(id);
    }

    @Override
    public void deleteCategory(Integer id) {
        Optional<Category> category2find = categoryRepository.findById(id);
        if (!category2find.isPresent()){
            throw new RuntimeException("id not found");
        }

        categoryRepository.delete(category2find.get());
    }

    @Override
    public Page<Category> getAllCategories(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        return categoryRepository.findAll(pageRequest);
    }
}
