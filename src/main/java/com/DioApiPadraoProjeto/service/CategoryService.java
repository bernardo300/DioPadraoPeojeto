package com.DioApiPadraoProjeto.service;

import com.DioApiPadraoProjeto.model.Category;
import com.DioApiPadraoProjeto.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CategoryService {
        Iterable<Category> all();
        Category findById(Long id);
        void insertOne(Category category);
        void updateById(Long id, Category category);
        void deleteById(Long id);
}
