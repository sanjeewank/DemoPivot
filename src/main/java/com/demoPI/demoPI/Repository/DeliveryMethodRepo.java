package com.demoPI.demoPI.Repository;

import com.demoPI.demoPI.Models.DeliveryMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeliveryMethodRepo extends JpaRepository<DeliveryMethod,Integer> {
    @Query(value = "SELECT del_methodid FROM `delivery_method` WHERE del_method_name =?1", nativeQuery = true)
    Integer getProductCategoryIdByName(String name);

    @Query(value = "SELECT del_method_name FROM `delivery_method` WHERE del_methodid = ?1", nativeQuery = true)
    String getDeliveryMethodNameById(int id);

}
