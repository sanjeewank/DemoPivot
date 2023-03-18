package com.demoPI.demoPI.Repository;

import com.demoPI.demoPI.Models.SalesProfitsSummery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesProfitsRepo extends JpaRepository<SalesProfitsSummery,Integer> {
}
