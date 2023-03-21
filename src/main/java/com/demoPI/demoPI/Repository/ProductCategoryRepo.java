package com.demoPI.demoPI.Repository;

import com.demoPI.demoPI.Models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Integer> {
    @Query(value = "SELECT productid FROM `product_category` WHERE product_name =?1", nativeQuery = true)
    Integer getProductCategoryIdByName(String name);

    @Query(value = "SELECT product_name FROM `product_category` WHERE productid = ?1", nativeQuery = true)
    String getProductNameById(int id);
}
