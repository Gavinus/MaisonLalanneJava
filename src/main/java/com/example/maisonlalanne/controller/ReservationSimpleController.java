package com.example.maisonlalanne.controller;
import com.example.maisonlalanne.model.beans.ReservationSimpleBean;
import com.example.maisonlalanne.services.ReservationSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/reservationsimple")
public class ReservationSimpleController {
    @Autowired
    private ReservationSimpleService reservationsimpleservice;

    //http://localhost:8080/reservationsimple/1
    @GetMapping("/{id}") //
    public ReservationSimpleBean getUserId(@PathVariable Long id) {
        System.out.println("/getUserId id=" + id);

        return reservationsimpleservice.getById(id);
    }

    //http://localhost:8080/reservationsimple/allreservationsimple
    // avoir ttes les reservations
    @GetMapping("/allreservationsimple")
    public List<ReservationSimpleBean> allReservationSimple() {
        System.out.println("/allreservationsimple");
        return reservationsimpleservice.getAllReservationSimple();
    }

    //http://localhost:8080/reservationsimple/adduptadereservationsimple
    //Ajouter une reservationsimple
    @PostMapping("/adduptadereservationsimple")
    public void addOrUpdateReservationsimple(@RequestBody ReservationSimpleBean reservationSimple) throws Exception {
        System.out.println("/adduptadereservationsimple");

        reservationsimpleservice.addOrUpdateReservationSimple(reservationSimple);
    }


}


