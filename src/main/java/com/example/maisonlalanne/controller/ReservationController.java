package com.example.maisonlalanne.controller;

import com.example.maisonlalanne.model.beans.ReservationBean;
import com.example.maisonlalanne.model.beans.UserBean;
import com.example.maisonlalanne.model.repository.ReservationRepository;
import com.example.maisonlalanne.services.ReservationService;
import com.example.maisonlalanne.services.UserService;
import com.example.maisonlalanne.utils.DateUtils;
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

    @PostMapping("/addreservationtest")
    public Object addResaTest(@RequestBody ReservationBean reservationbean, @RequestParam String dateIn, @RequestParam String dateOut) throws Exception {
        System.out.println("dateIn et Out : " + reservationbean + dateIn + dateOut);
        try {
            Long resatest = DateUtils.dateToLong(dateIn);
            DateUtils.dateToLong(dateOut);
            System.out.println("reservationbean: " + reservationbean);
            return reservationbean;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mauvais user");
        }
        return null;
    }



}

    //http://localhost:8080/reservation/savereservation
//    @PostMapping("/savereservation")
//    public void saveUser(@RequestBody ReservationBean reservation) throws ParseException {
////        long epoch = 0;
////        String str = "2014-07-04 04:05:10";   // UTC
//        // 121655473185461
////        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
////        Date datenew = df.parse(str);
////        epoch = datenew.getTime() / 1000;
//        System.out.println("/savereservation : " + reservation.getNbday() + " -- " + reservation.getDateIn() + " -- " + reservation.getDateOut()+ " -- " + reservation.getDatecreate());
//        listreservation.add(reservation);
//        System.out.println("Les reservation sont: " + reservation);
//    }

