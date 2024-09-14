package com.example.ecommerce.service;

import com.example.ecommerce.model.ProductDetails;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductDetails> getAllProducts(){
        return repository.findAll();
    }

    public ProductDetails addNewProducts(ProductDetails details){
        return repository.save(details);
    }

    public ProductDetails getProductById(Long id){
        return Optional.ofNullable(repository.findById(id)).get().orElse(new ProductDetails());
    }

    public ProductDetails updateproduct(ProductDetails productDetails) {
        ProductDetails existingProduct = Optional.ofNullable(repository.findById(productDetails.getProductId())).get().orElse(null);
        if (existingProduct == null) {
            return repository.save(productDetails);
        }
        if (productDetails.getDescription() != null) {
            existingProduct.setDescription(productDetails.getDescription());
        }
        if (productDetails.getPrice() != null) {
            existingProduct.setPrice(productDetails.getPrice());
        }
        if (productDetails.getSku() != null) {
            existingProduct.setSku(productDetails.getSku());
        }
        if (productDetails.getStock() != null) {
            existingProduct.setStock(productDetails.getStock());
        }
        return repository.save(existingProduct);
    }
}
