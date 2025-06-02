package com.oleksii.blog.services;

import com.oleksii.blog.domain.entities.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
