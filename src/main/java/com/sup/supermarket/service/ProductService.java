package com.sup.supermarket.service;

import com.sup.supermarket.entity.Product;
import com.sup.supermarket.exception.ProductNotFoundException;
import com.sup.supermarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    public Product getProductById(String id){
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product is not found with Id: " + id));
        return product;
    }

    public Product updateProduct(Product product, String id){
        Product existingProduct = repository.findById(id).orElseThrow(()->new ProductNotFoundException("Product does not exist with id:"+id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBarcode(product.getBarcode());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setExpirationDate(product.getExpirationDate());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setStockQuantity(product.getStockQuantity());
        existingProduct.setSupplierId(product.getSupplierId());
        existingProduct.setUnit(product.getUnit());
        existingProduct.setWeight(product.getWeight());
        return repository.save(existingProduct);
    }

    public void deleteProduct(String id){
        repository.deleteById(id);
    }
}
