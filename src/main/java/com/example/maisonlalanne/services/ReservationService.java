package com.example.maisonlalanne.services;
import com.example.maisonlalanne.model.beans.ReservationBean;
import com.example.maisonlalanne.model.repository.BedroomRepository;
import com.example.maisonlalanne.model.repository.ReservationRepository;
import com.example.maisonlalanne.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class ReservationService {
    @Autowired
    private ReservationRepository reservationrepository;
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private BedroomRepository bedroomrepository;


    public List<ReservationBean> getAllReservation() {
        System.out.println("ReservationService");
        return reservationrepository.findAll();
    }


    // A VOIR POUR LA V2, POUR RESERVATION CHECK L'ID USER et ID SESSION
    public void addOrUpdateReservation(ReservationBean toSave) throws Exception {
        //Controle des données
//        if (toSave == null) {
//            throw new Exception("reservation missing");
//        } else if (toSave.getDatecreate() == 0) {
//            throw new Exception("DateCreate missing");
//        } else if (toSave.getDatein() == 0) {
//            throw new Exception("DateIn missing");
//        } else if (toSave.getDateout() == 0) {
//            throw new Exception("DateOut incorrecte");
//        } else if (toSave.getBedroom() == null) {
//            throw new Exception("Chambre non selectionné");
//        }
//        if (toSave == null) {
//            throw new Exception("reservation missing");
//        } else if (toSave.getBedroom() == null) {
//            throw new Exception("Chambre non selectionné : " + toSave.getBedroom());
//        }
//
//        //Pour changer les dates en long
////        //Pour datecreate
////        toSave.setDatecreate(new Date().getTime());
////        //Pour dateIn
////        toSave.setDatein(new Date().getTime());
////        //Pour dateOut
////        toSave.setDateout(new Date().getTime());
//
////        toSave.setBedroom(new BedroomBean());
////        toSave.setUser(new UserBean());
//
//
//        //Si on a le même code on modifie pour le name
//        ReservationBean fromBaseDatecreate = reservationrepository.findByDatecreate(toSave.getDatecreate());
//        if (fromBaseDatecreate != null) {
//            //Si ce code est déjà en base
//            toSave.setId(fromBaseDatecreate.getId());
//        }
//        //Si on a le même code on modifie pour le dateIn
//        ReservationBean fromBaseDatein = reservationrepository.findByDatein(toSave.getDatein());
//        if (fromBaseDatein != null) {
//            //Si ce code est déjà en base
//            toSave.setId(fromBaseDatein.getId());
//        }
//        //Si on a le même code on modifie pour dateOut
//        ReservationBean fromBaseDateout = reservationrepository.findByDateout(toSave.getDateout());
//        if (fromBaseDateout != null) {
//            //Si ce code est déjà en base
//            toSave.setId(fromBaseDateout.getId());
//        }
//
//        ReservationBean fromBaseBedroom = reservationrepository.findByBedroom_Id(toSave.getId());
//        if (fromBaseBedroom != null) {
//            //Si ce code est déjà en base
//            toSave.setBedroom(fromBaseBedroom.getBedroom());
//        }
//
//        reservationrepository.save(toSave);
//
    }

    public void create(ReservationBean reservationBean) throws Exception {
//        if (reservationBean == null) {
//            throw new Exception("reservation missing");
//        } else if (reservationBean.getDatein() == null) {
//            throw new Exception("DateIn except : " + reservationBean.getDatein());
//        } else if (reservationBean.getDateout() == null) {
//            throw new Exception("getDateout non selectionné : " + reservationBean.getDateout());
//        } else if (reservationBean.getBedroom() == null) {
//            throw new Exception("Bedroom except : " + reservationBean.getBedroom());
//        } else if (reservationBean.getUser() == null) {
//            throw new Exception("getUser non selectionné : " + reservationBean.getUser());
//        }

        //Pour changer les dates en long
        //Pour datecreate
//        reservationBean.setDatecreate(reservationBean.getDatecreate());
//        System.out.println(reservationBean.getDatecreate());
//        //Pour dateIn
//        reservationBean.setDatein(reservationBean.getDatein());
//        System.out.println(reservationBean.getDatein());
//        //Pour dateOut
//        reservationBean.setDateout(new Date().getTime());
//        System.out.println(reservationBean.getDateout());

 //       reservationBean.setUser(userrepository.findById(reservationBean.getUser().getId()).orElse(null));
   //     reservationBean.setBedroom(bedroomrepository.findById(reservationBean.getBedroom().getId()).orElse(null));
        reservationrepository.save(reservationBean);
    }

//    public ReservationBean create(ReservationBean reservationBean) {
//        return create(reservationBean, 0L, 0L);
//    }

//    public ReservationBean create(Date dateIn, Date dateOut, Date datecreate, Long id_user, Long id_bedroom) throws Exception {
//        ReservationBean reservationBean = new ReservationBean(dateIn,dateOut,datecreate,id_user,id_bedroom);
//
//        // Pour verifier si mon user existe grace a l'id sinon renvoi null
//        reservationBean.setUser(userrepository.findById(id_user).orElse(null));
//
//        // Pour verifier si ma bedroom existe grace a l'id sinon renvoi null
//        reservationBean.setBedroom(bedroomrepository.findById(id_bedroom).orElse(null));
//
//
//        //save de la reservationBean
//        reservationrepository.save(reservationBean);
//        return reservationBean;
//    }
}

