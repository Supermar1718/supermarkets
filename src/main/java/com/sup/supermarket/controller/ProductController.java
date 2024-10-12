package com.sup.supermarket.controller;

import com.sup.supermarket.entity.Product;
import com.sup.supermarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService service;

    //create the product
    @PostMapping("/save")
    public ResponseEntity<Product> registerProduct(@RequestBody Product product) {
        Product saveProduct = service.saveProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    //get List of Product
    @GetMapping("/list")
    private ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProduct = service.getAllProduct();
        return ResponseEntity.ok(allProduct);
    }

    //get Product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product productById = service.getProductById(id);
        return ResponseEntity.ok(productById);
    }

    //update Product
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, String id) {
        Product updateProduct = service.updateProduct(product, id);
        return ResponseEntity.ok(updateProduct);
    }

    //delete product by Id
    private ResponseEntity<String> deleteProductById(@PathVariable String id) {
        service.deleteProduct(id);
        return ResponseEntity.ok("Product Deleted Successfully" + id);
    }

}
