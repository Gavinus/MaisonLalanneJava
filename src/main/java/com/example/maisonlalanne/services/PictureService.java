package com.example.maisonlalanne.services;


import com.example.maisonlalanne.model.beans.PictureBean;
import com.example.maisonlalanne.model.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public List<PictureBean> getAllPicture() {
        return pictureRepository.findAll();
    }

    public List<String> getUrlsByBedroomId(Long bedroomId) {
        List<String> urls = new ArrayList<>();
        List<PictureBean> bedroomImages = pictureRepository.findByBedroomId(bedroomId);
        for (PictureBean bedroomImage : bedroomImages) {
            urls.add(bedroomImage.getLink());
        }
        return urls;
    }




}
