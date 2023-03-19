package com.demoPI.demoPI.Repository;

import com.demoPI.demoPI.Models.CustomerSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerSegmentRepo extends JpaRepository<CustomerSegment,Integer> {
    @Query(value = "SELECT cus_segmentid FROM `customer_segment` WHERE cus_segment_name =?1", nativeQuery = true)
    Integer getProductCategoryIdByName(String name);
}
