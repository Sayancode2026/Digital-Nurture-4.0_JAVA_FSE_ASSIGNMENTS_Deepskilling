package com.ecommerce.model;

/**
 * Represents the core Product entity in the e-commerce domain.
 * This class is an immutable data object holding product attributes.
 */
public final class Product {

    private final String productId;
    private final String productName;
    private final String category;

    /**
     * Constructs a new Product.
     * @param productId A unique identifier for the product (e.g., "P001").
     * @param productName The display name of the product.
     * @param category The category to which the product belongs.
     */
    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // --- Accessor Methods ---

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Product[ID=%s, Name=%s, Category=%s]",
                             productId, productName, category);
    }
}