package com.example.ecommerce.repository;

import com.example.ecommerce.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository< ProductDetails, Long > {


}
