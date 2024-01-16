package com.neobis.neoQuiz.service;

import com.neobis.neoQuiz.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category getCategoryByName(String name);
}
