package com.ecommerce;

import com.ecommerce.model.Product;
import com.ecommerce.search.SearchAlgorithm;

import java.util.Arrays;
import java.util.Comparator;


public class Main {

    public static void main(String[] args) {
        Product[] products = {
            new Product("P003", "Laptop", "Electronics"),
            new Product("P001", "Smartphone", "Electronics"),
            new Product("P005", "Coffee Maker", "Home Appliances"),
            new Product("P002", "T-shirt", "Apparel"),
            new Product("P004", "Book", "Books")
        };
        String targetId = "P004";

        System.out.println("### Linear Search Demonstration ###");
        long startTimeLinear = System.nanoTime();
        Product result1 = SearchAlgorithm.linearSearch(products, targetId);
        long endTimeLinear = System.nanoTime();
        System.out.println("Result: " + (result1 != null ? result1 : "Not Found"));
        System.out.println("Linear Search took: " + (endTimeLinear - startTimeLinear) + " ns");
        System.out.println("-------------------------------------\n");

        System.out.println("### Binary Search Demonstration ###");
        // Pre-computation step: Sorting the array
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
        System.out.println("Array has been sorted by productId for binary search.");

        long startTimeBinary = System.nanoTime();
        Product result2 = SearchAlgorithm.binarySearch(products, targetId);
        long endTimeBinary = System.nanoTime();
        System.out.println("\nResult: " + (result2 != null ? result2 : "Not Found"));
        System.out.println("Binary Search took: " + (endTimeBinary - startTimeBinary) + " ns");
        System.out.println("-------------------------------------");
    }
}