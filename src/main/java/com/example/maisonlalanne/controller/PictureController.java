package com.example.maisonlalanne.controller;
import com.example.maisonlalanne.model.beans.PictureBean;
import com.example.maisonlalanne.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    //http://localhost:8080/picture/allpicture    trouver toutes les pictures
    @GetMapping("/allpicture")
    public List<PictureBean> allPicture() {
        System.out.println("/allpicture");

        return pictureService.getAllPicture();
    }

}
