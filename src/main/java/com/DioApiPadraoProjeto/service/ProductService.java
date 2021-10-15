package com.DioApiPadraoProjeto.service;

import com.DioApiPadraoProjeto.model.Product;

public interface ProductService {
    Iterable<Product> all();
    Product findById(Long id);
    void insertOne(Product product);
    void updateById(Long id, Product product);
    void deleteById(Long id);
}
