package com.grupoG33.reto3.controller;

import com.grupoG33.reto3.dbo.MessageDbo;
import com.grupoG33.reto3.dbo.ReservationDbo;
import com.grupoG33.reto3.model.ClientModel;
import com.grupoG33.reto3.model.MessageModel;
import com.grupoG33.reto3.model.ReservationModel;
import com.grupoG33.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> obtenerPorId(@PathVariable int id){
        return reservationService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationModel reservation){
        reservationService.crear(reservation);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        reservationService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ReservationDbo reservationInput){
        reservationService.actualizar(reservationInput);
    }
}
