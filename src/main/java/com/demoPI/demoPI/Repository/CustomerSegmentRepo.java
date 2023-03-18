package com.demoPI.demoPI.Repository;

import com.demoPI.demoPI.Models.CustomerSegment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSegmentRepo extends JpaRepository<CustomerSegment,Integer> {
}
