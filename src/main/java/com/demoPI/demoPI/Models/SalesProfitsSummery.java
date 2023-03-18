package com.demoPI.demoPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SalesProfitsSummery {
    @Id
    private int year;
    private String productCategory;
    private String customerSegment;
    private String deliveryMethod;
    private String sumOfSales;
    private String sumOfProfits;

}
