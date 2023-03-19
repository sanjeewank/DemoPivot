package com.demoPI.demoPI.Repository;

import com.demoPI.demoPI.Models.SalesProfitsSummery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalesProfitsRepo extends JpaRepository<SalesProfitsSummery,Integer> {
    @Query(value = "SELECT ID FROM sales_profits_summery ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer getLastID();
}