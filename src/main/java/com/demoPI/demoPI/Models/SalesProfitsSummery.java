package com.demoPI.demoPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SalesProfitsSummery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;
    private int year;
    private String productCategory;
    private String customerSegment;
    private String deliveryMethod;
    private double sumOfSales;
    private double sumOfProfits;

}
