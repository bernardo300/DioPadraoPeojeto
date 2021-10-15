package com.DioApiPadraoProjeto.service.impl;

import com.DioApiPadraoProjeto.model.Category;
import com.DioApiPadraoProjeto.model.CategoryRepository;
import com.DioApiPadraoProjeto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> all() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category>category =  categoryRepository.findById(id);
        return category.get();
    }

    @Override
    public void insertOne(Category category) {
        salvarCategory(category);
    }

    @Override
    public void updateById(Long id,Category category) {
        Optional<Category> categoryDB = categoryRepository.findById(id);
        if (categoryDB.isPresent()){
            salvarCategory(category);
        }
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    private void salvarCategory(Category category) {
        categoryRepository.save(category);
    }

}