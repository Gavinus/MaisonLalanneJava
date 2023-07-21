package com.example.maisonlalanne.controller;

import com.example.maisonlalanne.model.beans.BedroomBean;
import com.example.maisonlalanne.model.repository.BedroomRepository;
import com.example.maisonlalanne.services.BedroomService;
import com.example.maisonlalanne.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/bedroom")
public class BedroomController {

    @Autowired
    private BedroomService bedroomService;

    @Autowired
    private PictureService pictureService;

    ArrayList<BedroomBean> listbedroom = new ArrayList<>();


    //http://localhost:8080/bedroom/allbedroom
    @GetMapping("/allbedroom")
    public List<BedroomBean> allBedroom() {
        System.out.println("/allbedroom");
        return bedroomService.getAll();
    }

    // Endpoint pour récupérer les URL associées à une chambre par son ID
    @GetMapping("/{id}/allpictureById")
    public List<String> allPictureById(@PathVariable Long id) {
        System.out.println("/allpictureById");

        return pictureService.getUrlsByBedroomId(id);
    }

    //http://localhost:8080/bedroom/namebedroom
    @GetMapping("/namebedroom")
    public String findByNameAndDescription(String name) {
        System.out.println("/namebedroom" + name);
        return name;
    }

    //http://localhost:8080/bedroom/bedroom/1
    @GetMapping("/{id}")
    public BedroomBean getBedroomId(@PathVariable Long id) {
        System.out.println("/getBedroomId =" + id);


        return bedroomService.getById(id);
    }




    //http://localhost:8080/bedroom/savebedroom
    @PostMapping("/savebedroom")
    public void saveBedroom(@RequestBody BedroomBean bedroom) {
        //System.out.println("/savebedroom : " + user.getName() + " -- " + user.getFirstname() + " -- " + user.getMail());
        listbedroom.add(bedroom);
        System.out.println("Les bedrooms sont: " + bedroom);
    }
}
