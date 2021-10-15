package com.DioApiPadraoProjeto.service.impl;

import com.DioApiPadraoProjeto.model.Category;
import com.DioApiPadraoProjeto.model.CategoryRepository;
import com.DioApiPadraoProjeto.model.Product;
import com.DioApiPadraoProjeto.model.ProductRepository;
import com.DioApiPadraoProjeto.service.CategoryService;
import com.DioApiPadraoProjeto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;
    @Override
    public Iterable<Product> all() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product>product =  productRepository.findById(id);
        return product.get();
    }

    @Override
    public void insertOne(Product product) {
        salvarProduct(product);
    }

    @Override
    public void updateById(Long id,Product product) {
        Optional<Product> clienteDB = productRepository.findById(id);
        if (clienteDB.isPresent()){
            salvarProduct(product);
        }
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    private void salvarProduct(Product product) {
        Long id = product.getCategory().getId();
        Category category = categoryRepository.findById(id).orElseGet(()->{
            return new Category(-1l,"error","category not found!");
        });
        product.setCategory(category);
        productRepository.save(product);
    }
}
