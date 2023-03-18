package com.demoPI.demoPI.Models;

import java.util.ArrayList;

public class Product {
    private String productCategory;
    private ArrayList<DataStack> dataPack;

    public Product() {
        this.productCategory="";
        this.dataPack=new ArrayList<>();
    }


    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public ArrayList<DataStack> getDataPack() {
        return dataPack;
    }

    public void setDataPack(ArrayList<DataStack> dataPack) {
        this.dataPack = dataPack;
    }
    public void addStackData(DataStack ds){
        this.dataPack.add(ds);
    }

    public boolean hasData(){
        return this.getProductCategory() != "";
    }
    public void reset(){
        this.setProductCategory("");
        this.getDataPack().clear();
    }
}
