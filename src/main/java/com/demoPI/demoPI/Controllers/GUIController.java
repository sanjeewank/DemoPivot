package com.demoPI.demoPI.Controllers;

import ch.qos.logback.core.model.Model;
import com.demoPI.demoPI.Models.SalesProfitsSummery;
import com.demoPI.demoPI.Services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GUIController {
    @Autowired
    private ViewService viewService;



    public GUIController(){
        this.viewService=new ViewService();
    }

    @GetMapping(value = "/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping(value = "/upload")
    public String getUpload(){
        return "upload";
    }

    @GetMapping(value = "/view")
    public String getView(ModelMap model){
        List<Integer> options = new ArrayList<>();
        options=viewService.findAllYears();
        model.addAttribute("years", options);
        return "view";
    }

    @GetMapping(value = "/view/{year}")
    public String getViewWithData(@PathVariable int year, ModelMap model){
        List<Integer> options = new ArrayList<>();
        options=viewService.findAllYears();
        List<SalesProfitsSummery> salesProfitsList = new ArrayList<>();
        salesProfitsList=viewService.findAllSummeryData(year);
        model.addAttribute("years", options);
        model.addAttribute("dataStack", salesProfitsList);
        return "view";
    }

    @GetMapping(value = "/message")
    public String getMessage(){
        return "message";
    }
}
