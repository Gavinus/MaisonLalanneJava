package com.example.maisonlalanne.controller;
import com.example.maisonlalanne.model.beans.ReservationBean;
import com.example.maisonlalanne.model.repository.ReservationRepository;
import com.example.maisonlalanne.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationservice;

    @Autowired
    private ReservationRepository reservationrepository;

    //http://localhost:8080/reservation/allreservation
    // avoir ttes les reservations
    @GetMapping("/allreservation")
    public List<ReservationBean> allReservation() {
        System.out.println("/allreservation");
        return reservationservice.getAllReservation();
    }

    //http://localhost:8080/reservation/addreservation
    @PostMapping("/addreservation")
    public void addOrupdatereservation(@RequestBody ReservationBean reservationbean) throws Exception {
        System.out.println("/addreservation ca passe : " + reservationbean);

        reservationservice.create(reservationbean);
    }
}


