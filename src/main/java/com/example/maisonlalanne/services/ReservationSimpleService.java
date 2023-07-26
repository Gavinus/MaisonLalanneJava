package com.example.maisonlalanne.services;
import com.example.maisonlalanne.model.beans.ReservationSimpleBean;
import com.example.maisonlalanne.model.repository.ReservationSimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationSimpleService {
    @Autowired
    private ReservationSimpleRepository reservationsimplerepository;

    //http://localhost:8080/reservationsimple/allreservationsimple
    public List<ReservationSimpleBean> getAllReservationSimple() {
        System.out.println("reservationSimpleService");
        return reservationsimplerepository.findAll();
    }

    public void addOrUpdateReservationSimple(ReservationSimpleBean toSave) throws Exception {
        //Controle des données pour eventuel erreur
        if (toSave == null) {
            throw new Exception("reservation missing");
        } else if (toSave.getName() == null || toSave.getName().length() == 0) {
            throw new Exception("Name missing");
        } else if (toSave.getLastname() == null || toSave.getLastname().length() == 0) {
            throw new Exception("LastName missing");
        } else if (toSave.getEmail() == null || toSave.getEmail().length() == 0) {
            throw new Exception("Email incorrecte");
        } else if (toSave.getAddress() == null || toSave.getAddress().length() == 0) {
            throw  new Exception("adresse missing");
        } else if (toSave.getCity() == null || toSave.getCity().length() == 0) {
            throw  new Exception("city missing");
        } else if (toSave.getPhonenumber() == null || toSave.getPhonenumber().length() == 0) {
            throw  new Exception("phonenumber missing");
        } else if (toSave.getDateout() == null) {
            throw  new Exception("dateOut missing");
        } else if (toSave.getDatein() == null) {
            throw  new Exception("dateIn missing");
        }

        //Si on a le même code on modifie pour le name
//        ReservationSimpleBean fromBaseName = reservationsimplerepository.findByName(toSave.getName());
//        if (fromBaseName != null) {
//            //Si ce code est déjà en base
//            toSave.setId(fromBaseName.getId());
//        }

        reservationsimplerepository.save(toSave);
    }

    public ReservationSimpleBean getById(Long id) {
        if (id == null) {
            return null;
        }
        return reservationsimplerepository.findById(id).orElse(null);
    }
}

