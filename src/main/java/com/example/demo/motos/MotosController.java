package com.example.demo.motos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/motos")
public class MotosController {


    private final MotosService motosService;

    @Autowired
    public MotosController(MotosService motosService) {
        this.motosService = motosService;
    }

    @GetMapping
    public List<Motos> getMotos() {
        return motosService.getMotos();
    }

    @PostMapping
    public void registerNewMoto(@RequestBody Motos motos){
        motosService.addNewMoto(motos);
    }

    @DeleteMapping(path = "{motoId}")
    public void deleteMoto(@PathVariable("motoId")Long motoId){
        motosService.deleteMoto(motoId);
    }

    @PutMapping(path = "{motoId}")
    public void updateMoto(
      @PathVariable("motoId") Long motoId,
      @RequestParam(required = false) String model,
      @RequestParam(required = false) String brand){
        motosService.updateMoto(motoId, model, brand);
    }
}
