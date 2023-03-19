package com.demoPI.demoPI.Controllers;



import com.demoPI.demoPI.Services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    public UploadController(){
        uploadService = new UploadService();
    }

    @RequestMapping(value="/FileUpload", method= RequestMethod.POST)
    public ModelAndView  uploadFile(@RequestParam("File") MultipartFile File){
        uploadService.readFile(File);
        return new ModelAndView("redirect:/message?query=Data has been uploaded successfully");
    }

}
