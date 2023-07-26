package com.example.maisonlalanne.model.repository;
import com.example.maisonlalanne.model.beans.ReservationSimpleBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;


@Repository
public interface ReservationSimpleRepository extends JpaRepository<ReservationSimpleBean, Long> {
    ReservationSimpleBean findByDatein(Date datein);
    ReservationSimpleBean findByDateout(Date dateout);
    ReservationSimpleBean findByName(String name);
    ReservationSimpleBean findByAddress(String address);
    ReservationSimpleBean findByLastname(String lastname);
}