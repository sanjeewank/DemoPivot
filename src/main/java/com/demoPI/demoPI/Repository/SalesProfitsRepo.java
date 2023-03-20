package com.demoPI.demoPI.Repository;

import com.demoPI.demoPI.Models.SalesProfitsSummery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesProfitsRepo extends JpaRepository<SalesProfitsSummery,Integer> {
    @Query(value = "SELECT ID FROM sales_profits_summery ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer getLastID();

    @Query(value = "SELECT DISTINCT year FROM sales_profits_summery", nativeQuery = true)
    List<Integer> getDistinctYears();

    //List<SalesProfitsSummery> getAllByYear(int year);


}