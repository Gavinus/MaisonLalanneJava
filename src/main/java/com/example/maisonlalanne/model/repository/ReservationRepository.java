package com.example.maisonlalanne.model.repository;
import com.example.maisonlalanne.model.beans.ReservationBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;


@Repository
public interface ReservationRepository extends JpaRepository<ReservationBean, Long> {
    ReservationBean findByDatecreate(LocalDateTime datecreate);
    ReservationBean findByDatein(LocalDateTime datein);
    ReservationBean findByDateout(LocalDateTime dateout);
    ReservationBean findByBedroom_Id(Long id_bedroom);
    ReservationBean findByUser_Id(Long id_user);

}