package com.example.pos_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pos_system.models.Categories;
import com.example.pos_system.models.Products;
import com.example.pos_system.service.CategoriesService;
import com.example.pos_system.service.ProductsService;

@RestController
@RequestMapping("/api/v1.0.0/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        try {
            List<Products> products = productsService.getAllProducts();
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<?> getProductById(@PathVariable String product_id) {
        try {
            Products product = productsService.getProductById(product_id);

            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Products products) {
        try {
            // Extract product_id from orders
            String catagoriesId = products.getCategoriesId();

            // Find catagorie by their IDs
            Optional<Categories> catagoriesData = categoriesService.getCategoryById(catagoriesId);

            if (catagoriesData.isEmpty()) {
                return new ResponseEntity<>("catagories not found", HttpStatus.NOT_FOUND);
            }

            // Save the Product
            Products savedProducts = productsService.saveProduct(products);
            return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String product_id) {
        try {
            Products product = productsService.getProductById(product_id);
            if (product == null) {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }

            productsService.deleteProduct(product_id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{product_id}")
    public ResponseEntity<?> updateProduct(@PathVariable String product_id, @RequestBody Products updatedProducts) {
        try {
            // Find the existing product
            Products existingProduct = productsService.getProductById(product_id);
            if (existingProduct == null) {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }

            // Extract category ID from the updated product
            String categoriesId = updatedProducts.getCategoriesId();

            // Find category by its ID
            Optional<Categories> categoriesData = categoriesService.getCategoryById(categoriesId);
            if (categoriesData.isEmpty()) {
                return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
            }

            // Perform the update
            Products updatedProductData = productsService.updateProduct(product_id, updatedProducts);
            return new ResponseEntity<>(updatedProductData, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
