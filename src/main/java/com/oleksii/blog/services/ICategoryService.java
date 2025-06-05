package com.oleksii.blog.services;

import com.oleksii.blog.domain.entities.Category;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID id);
    Category getCategoryById(UUID id);
}
