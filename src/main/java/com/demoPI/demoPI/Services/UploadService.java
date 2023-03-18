package com.demoPI.demoPI.Services;

import com.demoPI.demoPI.Models.CustomerSegment;
import com.demoPI.demoPI.Models.DeliveryMethod;
import com.demoPI.demoPI.Models.ProductCategory;
import com.demoPI.demoPI.Repository.SalesProfitsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Service
public class UploadService {

    @Autowired
    private SalesProfitsRepo salesProfitsRepo;

    public UploadService(){
    }
    public void readFile(MultipartFile File){

    }
    public void saveData(){

    }


}
