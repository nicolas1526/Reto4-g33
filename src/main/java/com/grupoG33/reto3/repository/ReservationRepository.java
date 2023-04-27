package com.grupoG33.reto3.repository;

import com.grupoG33.reto3.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel,Integer> {

    //@Query(value = "SELECT count(*) FROM reto5g33.reservation where status = ?",nativeQuery = true)
    Integer countByStatus(String status);


    //@Query(value = "SELECT * FROM reto5g33.reservation where start_date >= ? and start_date <= ?",nativeQuery = true)
    List<ReservationModel> findByStartDateBetween(Date fechaInicial, Date fechaFinal);
}
