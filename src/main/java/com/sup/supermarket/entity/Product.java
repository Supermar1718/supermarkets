package com.sup.supermarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "product_details")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;               // Name of the product
    private String description;        // Description of the product
    private double price;              // Price of the product
    private String category;           // Category the product belongs to (e.g., dairy, produce, etc.)
    private String brand;              // Brand of the product
    private int stockQuantity;         // Quantity available in stock
    private String unit;               // Unit of measurement (e.g., kg, liters, etc.)
    private LocalDate expirationDate;  // Expiration date for perishable items
    private String barcode;            // Barcode for scanning
    private String supplierId;         // ID of the supplier providing the product
    private double weight;             // Weight of the product (if applicable)
    private String imageUrl;           // URL for the product image
    private boolean isActive;          // Status indicating if the product is active for sale
}
