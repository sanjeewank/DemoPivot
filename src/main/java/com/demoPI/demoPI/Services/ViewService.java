package com.demoPI.demoPI.Services;

import com.demoPI.demoPI.Repository.SalesProfitsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewService {
    @Autowired
    private SalesProfitsRepo salesProfitsRepo;

    public List<Integer> findAllYears(){
        return this.salesProfitsRepo.getDistinctYears();
    }
}
