package com.oleksii.blog.services.impl;

import com.oleksii.blog.domain.entities.Category;
import com.oleksii.blog.repositories.CategoryRepository;
import com.oleksii.blog.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}
