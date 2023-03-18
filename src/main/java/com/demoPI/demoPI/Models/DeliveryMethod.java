package com.demoPI.demoPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DeliveryMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int delMethodID;
    private String delMethodName;
}
