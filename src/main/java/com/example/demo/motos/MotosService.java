package com.example.demo.motos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MotosService {

    @Autowired
    public MotosService(MotosRepository motosRepository) {
        this.motosRepository = motosRepository;
    }

    private final MotosRepository motosRepository;


    public List<Motos> getMotos() {
        return motosRepository.findAll();
    }

    public void addNewMoto(Motos motos) {
        Optional<Motos> motosOptional = motosRepository
                .findMotosByModel(motos.getModel());
        if (motosOptional.isPresent()){
            throw new IllegalStateException("Model already present");
        }
        motosRepository.save(motos);
    }

    public void deleteMoto(Long motoId) {
        boolean exists = motosRepository.existsById(motoId);
        if (!exists){
            throw new IllegalStateException("Moto with id "+ motoId + " does not exist");
        }
        motosRepository.deleteById(motoId);
    }

    @Transactional
    public void updateMoto(Long motosId, String model, String brand) {
        Motos moto = motosRepository.findById(motosId)
                .orElseThrow(()-> new IllegalStateException(
                "Moto with id " + motosId + " does not exist"));

        if (model != null &&
        model.length() > 0 &&
        !Objects.equals(moto.getModel(), model)){
            moto.setModel(model);
        }

        if (brand != null &&
                brand.length() > 0 &&
                !Objects.equals(moto.getBrand(), brand)){
            moto.setBrand(brand);
        }




    }
}
