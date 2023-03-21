package com.demoPI.demoPI.Services;

import com.demoPI.demoPI.Models.SalesProfitsSummery;
import com.demoPI.demoPI.Repository.CustomerSegmentRepo;
import com.demoPI.demoPI.Repository.DeliveryMethodRepo;
import com.demoPI.demoPI.Repository.ProductCategoryRepo;
import com.demoPI.demoPI.Repository.SalesProfitsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewService {
    @Autowired
    private SalesProfitsRepo salesProfitsRepo;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Autowired
    private CustomerSegmentRepo customerSegmentRepo;

    @Autowired
    private DeliveryMethodRepo deliveryMethodRepo;



    public List<Integer> findAllYears(){
        return this.salesProfitsRepo.getDistinctYears();
    }

    public List<SalesProfitsSummery> findAllSummeryData(int year){
        List<SalesProfitsSummery> dataStack = salesProfitsRepo.getAllByYear(year);
        for(int i=0;i<dataStack.size();i++){
            dataStack.get(i).setProductCategory(productCategoryRepo.getProductNameById(Integer.parseInt(dataStack.get(i).getProductCategory())));
        }
        for(int i=0;i<dataStack.size();i++){
            dataStack.get(i).setCustomerSegment(customerSegmentRepo.getCustomerSegmentNameById(Integer.parseInt(dataStack.get(i).getCustomerSegment())));
        }
        for(int i=0;i<dataStack.size();i++){
           dataStack.get(i).setDeliveryMethod(deliveryMethodRepo.getDeliveryMethodNameById(Integer.parseInt(dataStack.get(i).getDeliveryMethod())));
        }

        return dataStack;
    }
}
