package com.ecommerce.search;

import com.ecommerce.model.Product;

public final class SearchAlgorithm {

    /**
     * Implements a linear search to find a product by its ID.
     * Time Complexity: O(n)
     *
     * @param products The array of products (need not be sorted).
     * @param targetId The unique ID of the product to find.
     * @return The matching Product object, or null if not found.
     */
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Implements a binary search to find a product by its ID.
     * PRECONDITION: The products array must be sorted by productId.
     * Time Complexity: O(log n)
     *
     * @param sortedProducts An array of Product objects, pre-sorted by productId.
     * @param targetId The unique ID of the product to find.
     * @return The matching Product object, or null if not found.
     */
    public static Product binarySearch(Product[] sortedProducts, String targetId) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProducts[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return sortedProducts[mid]; // Target found
            }
            if (comparison < 0) {
                left = mid + 1;       // Target is in the right half
            } else {
                right = mid - 1;      // Target is in the left half
            }
        }
        return null;
    }
}