package com.demoPI.demoPI.Services;

import com.demoPI.demoPI.Models.DataStack;
import com.demoPI.demoPI.Models.Product;
import com.demoPI.demoPI.Repository.CustomerSegmentRepo;
import com.demoPI.demoPI.Repository.DeliveryMethodRepo;
import com.demoPI.demoPI.Repository.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReadService {

    @Autowired
    ProductCategoryRepo productCategoryRepo;

    @Autowired
    CustomerSegmentRepo customerSegmentRepo;

    @Autowired
    DeliveryMethodRepo deliveryMethodRepo;


    private File CSVFile;
    private String CvsSplitBy;

    public FileReadService(File file){
        this.CSVFile=file;
        this.CvsSplitBy=",";
    }

    public File getCSV() {
        return this.CSVFile;
    }

    public String getCvsSplitBy(){
        return this.CvsSplitBy;
    }
    public Map<Integer, List<Product>> readAndGetData(){
        ArrayList<String> products = new ArrayList<String>();products.add("Furniture");products.add("Office Supplies");products.add("Technology");
        ArrayList<String> customers = new ArrayList<String>();customers.add("Consumer");customers.add("Corporate");customers.add("Home Office");customers.add("Small Business");
        ArrayList<String> deliveryMethods = new ArrayList<String>();deliveryMethods.add("Delivery Truck");deliveryMethods.add("Express Air");deliveryMethods.add("Regular Air");




        Map<Integer,List<Product>> CSVData = new HashMap<>();
        List<Product> CSVDataStack = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.getCSV()))) {
            String line = "";
            String firstLine =  br.readLine();
            String secondLine = br.readLine();
            String titleLine= br.readLine();
            String[] row = firstLine.split(this.getCvsSplitBy());
            int Year = Integer.parseInt(row[1]);
            row = titleLine.split(this.getCvsSplitBy());
            String firstTitle= row[1];
            String secondTitle= row[2];
            Product proCategory=new Product();
            DataStack stack = new DataStack();
            Map<String,Double> values = new HashMap();
            Map<String,Map<String,Double>> methodOfDelivery = new HashMap();
            while ((line = br.readLine()) != null) {
                row=line.split(this.CvsSplitBy);
                if(products.contains(row[0])){
                    if(!stack.getCustomerSegment().isEmpty()){
                        proCategory.addStackData(stack);
                        stack=new DataStack();
                    }
                    if(!proCategory.getProductCategory().equals("")){
                        CSVDataStack.add(proCategory);
                        proCategory=new Product();
                    }
                    proCategory.setProductCategory(row[0]);
                }
                if(customers.contains(row[0])){
                    if(!stack.getCustomerSegment().isEmpty()){
                        proCategory.addStackData(stack);
                        stack=new DataStack();
                    }
                    stack.setCustomerSegment(row[0]);
                }
                if(deliveryMethods.contains(row[0])){
                    values.put(firstTitle,Double.valueOf(row[1]));
                    values.put(secondTitle,Double.valueOf(row[2]));
                    methodOfDelivery.put(row[0], values);
                    values = new HashMap();
                    stack.addDataIntoDeliveryData(methodOfDelivery);
                    methodOfDelivery = new HashMap();

                }
            }
            proCategory.getDataPack().add(stack);
            CSVDataStack.add(proCategory);
            CSVData.put(Year, CSVDataStack);
            return CSVData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
