package com.demoPI.demoPI.Services;

import com.demoPI.demoPI.Models.DataStack;
import com.demoPI.demoPI.Models.Product;
import com.demoPI.demoPI.Models.SalesProfitsSummery;
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

    private SalesProfitsSummery salesProfitsSummery;

    private DataSavingService(){
        this.salesProfitsSummery = new SalesProfitsSummery();
    }

    private static Logger logger = LoggerFactory.getLogger(DataSavingService.class);

    public void UpdateDB(Map<Integer, List<Product>> csvData){
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
                                                            this.salesProfitsRepo.save(salesProfitsSummery);
                                                        }
                                                );
                                            }
                                    );
                                }
                        );
                    }
            );
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
