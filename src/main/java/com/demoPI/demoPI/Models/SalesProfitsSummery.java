package com.demoPI.demoPI.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(indexes = {@Index(name = "my_index", columnList = "productCategory, customerSegment, deliveryMethod,year", unique = true)})
@Data
public class SalesProfitsSummery {
    @Id
    private int ID;
    private int year;
    @Column(nullable = false)
    private String productCategory;
    @Column(nullable = false)
    private String customerSegment;
    @Column(nullable = false)
    private String deliveryMethod;
    private double sumOfSales;
    private double sumOfProfits;

}
