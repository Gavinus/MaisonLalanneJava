package com.example.maisonlalanne.services;
import com.example.maisonlalanne.model.beans.BedroomBean;
import com.example.maisonlalanne.model.repository.BedroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BedroomService {
    @Autowired
    private BedroomRepository bedroomrepository;

    public List<BedroomBean> getAll(){
        System.out.println("BedroomService");
        return bedroomrepository.findAll();
    }

    public BedroomBean getById(Long id) {
        if (id == null) {
            return null;
        }

        return bedroomrepository.findById(id).orElse(null);
    }

    public List<BedroomBean> findByNameAndDescription(String name, String description){
        if (name == null && description == null) {
            return bedroomrepository.findAll();
        } else if (name == null) {
            return bedroomrepository.findByNameLikeIgnoreCase(name);
        } else if (description == null) {
            return bedroomrepository.findByDescription(description);
        }

        return bedroomrepository.findByNameLikeIgnoreCaseAndDescription(name, description);
    }

}
