package com.DioApiPadraoProjeto.controller;

import com.DioApiPadraoProjeto.model.Product;
import com.DioApiPadraoProjeto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@Service
@RequestMapping("products")
public class ProductRestController {
    @Autowired(required = true)
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> bucarTodos(){
        return ResponseEntity.ok(productService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> bucarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> inserir(@RequestBody Product cliente){
        productService.insertOne(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> atualizar(@PathVariable("id") Long id, @RequestBody Product cliente){
        productService.updateById(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product>deletar(@PathVariable("id") Long id){
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
