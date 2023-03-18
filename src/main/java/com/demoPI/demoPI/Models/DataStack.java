package com.demoPI.demoPI.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStack {

    private String customerSegment;
    private List<Map<String, Map<String,Double>>> deliveryData;

    public DataStack(){
        this.customerSegment="";
        this.deliveryData=new ArrayList<Map<String,Map<String,Double>>>();
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public List<Map<String, Map<String, Double>>> getDeliveryData() {
        return deliveryData;
    }

    public void setDeliveryData(List<Map<String, Map<String, Double>>> deliveryData) {
        this.deliveryData = deliveryData;
    }
    public void addDataIntoDeliveryData(Map<String,Map<String,Double>> ds){
        this.deliveryData.add(ds);
    }

    public void reset(){
        this.getDeliveryData().clear();
    }
}
