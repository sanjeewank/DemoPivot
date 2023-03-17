package com.demoPI.demoPI.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GUIController {

    @GetMapping(value = "/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping(value = "/upload")
    public String getUpload(){
        return "upload";
    }

    @GetMapping(value = "/view")
    public String getView(){
        return "view";
    }

}
