package com.example.ecommerce.controller;

import com.example.ecommerce.model.ProductDetails;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/return")
@Component
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/allproducts")
    public List<ProductDetails> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/addproduct")
    public ProductDetails addProduct(@RequestBody ProductDetails product) {
        return productService.addNewProducts(product);
    }

    @GetMapping("/product/{id}")
    public ProductDetails getProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/updateproduct")
    public ProductDetails updateproduct(@RequestBody ProductDetails product){
        return productService.updateproduct(product);
    }
}
