package com.neobis.neoQuiz.service.seviceImpl;

import com.neobis.neoQuiz.entity.Category;
import com.neobis.neoQuiz.repository.CategoryRepo;
import com.neobis.neoQuiz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    @Override
    public List<Category> getAllCategories() {
        try {
            return categoryRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepo.findById(categoryId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Category with id " + categoryId + " not found"));
    }
    @Override
    public Category getCategoryByName(String name) {
        return Optional.ofNullable(categoryRepo.findByName(name)).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Category with name " + name + " not found"));
    }
}
