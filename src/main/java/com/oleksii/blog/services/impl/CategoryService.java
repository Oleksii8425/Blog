package com.oleksii.blog.services.impl;

import com.oleksii.blog.domain.entities.Category;
import com.oleksii.blog.repositories.ICategoryRepository;
import com.oleksii.blog.services.ICategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final ICategoryRepository ICategoryRepository;

    @Override
    public List<Category> listCategories() {
        return ICategoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional// makes multiple calls to a database (lines 27 and 31) happen in a single transaction
    public Category createCategory(Category category) {
        String categoryName = category.getName();
        if (ICategoryRepository.existsByNameIgnoreCase(categoryName)) {
            throw new IllegalArgumentException("Category already exists with name: " + categoryName);
        }

        return ICategoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = ICategoryRepository.findById(id);
        if (category.isPresent()) {
            if (!category.get().getPosts().isEmpty()) {
                throw new IllegalStateException("Category has posts associated with it!");
            }

            ICategoryRepository.deleteById(id);
        }
    }
}
