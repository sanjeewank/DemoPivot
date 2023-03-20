package com.demoPI.demoPI.Services;

import com.demoPI.demoPI.Models.DataStack;
import com.demoPI.demoPI.Models.Product;
import com.demoPI.demoPI.Models.SalesProfitsSummery;
import com.demoPI.demoPI.Repository.CustomerSegmentRepo;
import com.demoPI.demoPI.Repository.DeliveryMethodRepo;
import com.demoPI.demoPI.Repository.ProductCategoryRepo;
import com.demoPI.demoPI.Repository.SalesProfitsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataSavingService {
    @Autowired
    private SalesProfitsRepo salesProfitsRepo;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Autowired
    private CustomerSegmentRepo customerSegmentRepo;

    @Autowired
    private DeliveryMethodRepo deliveryMethodRepo;


    private SalesProfitsSummery salesProfitsSummery;

    private DataSavingService(){
        this.salesProfitsSummery = new SalesProfitsSummery();
    }


    public boolean UpdateDB(Map<Integer, List<Product>> csvData){
        List<SalesProfitsSummery> ListSalesProfitsSummery = new ArrayList<>();
        List<Product> CSVDataStack = new ArrayList<>();
        int Year;
        Year = csvData.keySet().stream().findFirst().get();
        CSVDataStack=(List) csvData.values().toArray()[0];
        this.salesProfitsSummery.setYear(Year);
        try {
            CSVDataStack.forEach(
                    (n) -> {
                        this.salesProfitsSummery.setProductCategory(n.getProductCategory());
                        ArrayList<DataStack> stacks =n.getDataPack();
                        stacks.forEach(
                                (o) -> {
                                    DataStack stack = o;
                                    this.salesProfitsSummery.setCustomerSegment(stack.getCustomerSegment());
                                    List<Map<String,Map<String,Double>>> deliveryData = new ArrayList<>();
                                    deliveryData = stack.getDeliveryData();
                                    deliveryData.forEach(
                                            (p) -> {
                                                this.salesProfitsSummery.setDeliveryMethod(p.keySet().stream().findFirst().get());
                                                p.values().forEach(
                                                        (Q) -> {
                                                            Map<String,Double> values = new HashMap();
                                                            values=Q;
                                                            ArrayList<Double> salesAndProfit = new ArrayList<>();
                                                            values.entrySet().forEach(entry -> {
                                                                salesAndProfit.add(entry.getValue());
                                                            });
                                                            this.salesProfitsSummery.setSumOfSales(salesAndProfit.get(0));
                                                            this.salesProfitsSummery.setSumOfProfits(salesAndProfit.get(1));
                                                            if(salesProfitsRepo.getLastID()==null){
                                                                salesProfitsSummery.setID(1);
                                                            }
                                                            if(salesProfitsSummery.getProductCategory().length()>1){
                                                                salesProfitsSummery.setProductCategory(String.valueOf(productCategoryRepo.getProductCategoryIdByName(salesProfitsSummery.getProductCategory())));
                                                            }
                                                            if(salesProfitsSummery.getCustomerSegment().length()>1){
                                                                salesProfitsSummery.setCustomerSegment(String.valueOf(customerSegmentRepo.getProductCategoryIdByName(salesProfitsSummery.getCustomerSegment())));
                                                            }
                                                            if(salesProfitsSummery.getDeliveryMethod().length()>1){
                                                                salesProfitsSummery.setDeliveryMethod(String.valueOf(deliveryMethodRepo.getProductCategoryIdByName(salesProfitsSummery.getDeliveryMethod())));
                                                            }
                                                            salesProfitsRepo.save(salesProfitsSummery);
                                                            salesProfitsSummery.setID(salesProfitsRepo.getLastID()+1);
                                                        }
                                                );
                                            }
                                    );
                                }
                        );
                    }
            );
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
