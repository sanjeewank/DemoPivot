package com.demoPI.demoPI.Services;

import com.demoPI.demoPI.Models.*;
import com.demoPI.demoPI.Repository.SalesProfitsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UploadService {

    @Autowired
    private DataSavingService dataSavingService;

    @Autowired
    private SalesProfitsRepo salesProfitsRepo;

    public UploadService(){
    }
    public boolean readFile(MultipartFile File){
        File file = null;
        try{
            file=convertMultipartToFile(File);
        }catch (Exception e){
            return false;
        }
        FileReadService fileReadService = new FileReadService(file);
        Map<Integer, List<Product>> fileData = new HashMap<>();
        fileData=fileReadService.readAndGetData();
        try{
            this.saveData(fileData);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean saveData(Map<Integer, List<Product>> csvData){
        return this.dataSavingService.UpdateDB(csvData);
    }

    public File convertMultipartToFile(MultipartFile multipartFile) throws IOException, IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(multipartFile.getBytes());
        outputStream.close();
        return file;
    }
}
