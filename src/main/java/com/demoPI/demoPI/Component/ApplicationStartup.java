package com.demoPI.demoPI.Component;

import com.demoPI.demoPI.Models.CustomerSegment;
import com.demoPI.demoPI.Models.DeliveryMethod;
import com.demoPI.demoPI.Models.ProductCategory;
import com.demoPI.demoPI.Repository.CustomerSegmentRepo;
import com.demoPI.demoPI.Repository.DeliveryMethodRepo;
import com.demoPI.demoPI.Repository.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private CustomerSegmentRepo customerSegmentRepo;
    @Autowired
    private DeliveryMethodRepo deliveryMethodRepo;
    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        resetDB();
        mockDB();
    }



    //resetDB
    public void resetDB(){
        customerSegmentRepo.deleteAll();
        deliveryMethodRepo.deleteAll();
        productCategoryRepo.deleteAll();
    }

    //mocking the DB
    public void mockDB(){
        ArrayList<String> products = new ArrayList<String>();products.add("Furniture");products.add("Office Supplies");products.add("Technology");
        ArrayList<String> customers = new ArrayList<String>();customers.add("Consumer");customers.add("Corporate");customers.add("Home Office");customers.add("Small Business");
        ArrayList<String> deliveryMethods = new ArrayList<String>();deliveryMethods.add("Delivery Truck");deliveryMethods.add("Express Air");deliveryMethods.add("Regular Air");

        for(String S:products){
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductName(S);
            this.productCategoryRepo.save(productCategory);
        }
        for(String S:customers){
            CustomerSegment customerSegment = new CustomerSegment();
            customerSegment.setCusSegmentName(S);
            this.customerSegmentRepo.save(customerSegment);
        }
        for(String S:deliveryMethods){
            DeliveryMethod deliveryMethod = new DeliveryMethod();
            deliveryMethod.setDelMethodName(S);
            this.deliveryMethodRepo.save(deliveryMethod);
        }
    }
}