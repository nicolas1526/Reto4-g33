package com.grupoG33.reto3.service;

import com.grupoG33.reto3.dbo.ScoreDbo;
import com.grupoG33.reto3.model.ReservationModel;
import com.grupoG33.reto3.model.ScoreModel;
import com.grupoG33.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    public List<ScoreModel> obtener(){
        return scoreRepository.findAll();
    }

    public void crear(ScoreModel score){
        scoreRepository.save(score);
    }

    public void eliminar(int id){
        scoreRepository.deleteById(id);
    }

    public void actualizar(ScoreDbo scoreInput) {
        Optional<ScoreModel> scoreDb = scoreRepository.findById(scoreInput.getIdScore());
        if(scoreDb.isPresent()){
            ScoreModel score = scoreDb.get();
            if(scoreInput.getStars() != null){
                score.setStars(scoreInput.getStars());
            }
            scoreRepository.save(score);
        }
    }

    public Optional<ScoreModel> obtenerPorId(int id) {
        return scoreRepository.findById(id);
    }
}
