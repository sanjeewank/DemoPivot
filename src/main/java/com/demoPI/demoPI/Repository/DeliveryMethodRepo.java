package com.demoPI.demoPI.Repository;

import com.demoPI.demoPI.Models.DeliveryMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryMethodRepo extends JpaRepository<DeliveryMethod,Integer> {
}
