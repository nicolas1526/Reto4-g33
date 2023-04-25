package com.grupoG33.reto3.service;

import com.grupoG33.reto3.dbo.GamaDbo;
import com.grupoG33.reto3.model.GamaModel;
import com.grupoG33.reto3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {

    @Autowired
    GamaRepository gamaRepository;

    public List<GamaModel> obtener(){
        return gamaRepository.findAll();
    }

    public void crear(GamaModel gama){
        gamaRepository.save(gama);
    }

    public void eliminar(int id){
        gamaRepository.deleteById(id);
    }

    public void actualizar(GamaDbo gamaInput) {
        Optional<GamaModel> gamaDb = gamaRepository.findById(gamaInput.getIdGama());
        if(gamaDb.isPresent()){
            GamaModel gama = gamaDb.get();
            if(gamaInput.getName() != null){
                gama.setName(gamaInput.getName());
            }
            if(gamaInput.getDescription() != null){
                gama.setDescription(gamaInput.getDescription());
            }
            if(gamaInput.getCars() != null){
                gama.setCars(gamaInput.getCars());
            }
            gamaRepository.save(gama);
        }
    }

    public Optional<GamaModel> obtenerPorId(int id) {
        return gamaRepository.findById(id);
    }
}
