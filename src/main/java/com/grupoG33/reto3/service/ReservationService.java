package com.grupoG33.reto3.service;

import com.grupoG33.reto3.dbo.ReservationDbo;
import com.grupoG33.reto3.model.MessageModel;
import com.grupoG33.reto3.model.ReservationModel;
import com.grupoG33.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<ReservationModel> obtener(){
        return reservationRepository.findAll();
    }

    public void crear(ReservationModel reservation){
        reservationRepository.save(reservation);
    }

    public void eliminar(int id){
        reservationRepository.deleteById(id);
    }

    public void actualizar(ReservationDbo reservationInput) {
        Optional<ReservationModel> reservationDb = reservationRepository.findById(reservationInput.getIdReservation());
        if(reservationDb.isPresent()){
            ReservationModel reservation = reservationDb.get();
            if (reservationInput.getStartDate() != null){
                reservation.setStartDate(reservationInput.getStartDate());
            }
            if (reservationInput.getDevolutionDate() != null){
                reservation.setDevolutionDate(reservationInput.getDevolutionDate());
            }
            if (reservationInput.getScore() != null){
                reservation.setScore(reservationInput.getScore());
            }
            if (reservationInput.getStatus() != null){
                reservation.setStatus(reservationInput.getStatus());
            }
            if (reservationInput.getCar() != null){
                reservation.setCar(reservationInput.getCar());
            }
            if (reservationInput.getClient() != null){
                reservation.setClient(reservationInput.getClient());
            }
            reservationRepository.save(reservation);
        }
    }

    public Optional<ReservationModel> obtenerPorId(int id) {
        return reservationRepository.findById(id);
    }
}
