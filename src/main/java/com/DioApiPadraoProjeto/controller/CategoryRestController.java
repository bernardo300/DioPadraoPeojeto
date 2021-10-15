package com.DioApiPadraoProjeto.controller;

import com.DioApiPadraoProjeto.model.Category;
import com.DioApiPadraoProjeto.model.Product;
import com.DioApiPadraoProjeto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@Service
@RequestMapping("categories")
public class CategoryRestController {
    @Autowired(required = true)
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> bucarTodos(){
        return ResponseEntity.ok(categoryService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> bucarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Category> inserir(@RequestBody Category category){
        categoryService.insertOne(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> atualizar(@PathVariable("id") Long id, @RequestBody Category category){
        categoryService.updateById(id, category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category>deletar(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
