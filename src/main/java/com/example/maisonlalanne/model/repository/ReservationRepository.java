package com.example.maisonlalanne.model.repository;

import com.example.maisonlalanne.model.beans.ReservationBean;
import com.example.maisonlalanne.model.beans.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationBean, Long> {
    ReservationBean findByDatecreate(LocalDateTime datecreate);
    ReservationBean findByDatein(LocalDateTime datein);
    ReservationBean findByDateout(LocalDateTime dateout);

//    ReservationBean findByDatecreated(Date datecreate);
//    ReservationBean findByDateind(Date datein);
//    ReservationBean findByDateoutd(Date dateout);

    ReservationBean findByBedroom_Id(Long id_bedroom);
    ReservationBean findByUser_Id(Long id_user);

}