package com.proiectps.masina.controller;

import com.proiectps.masina.model.Masina;
import com.proiectps.masina.service.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class MasinaController {

    @Autowired
    private MasinaService masinaService;


    @GetMapping()
    public ResponseEntity findAllCars(){
        return ResponseEntity.status(HttpStatus.OK).body(masinaService.findAll());
    }

    @GetMapping("/{marca}")
    public ResponseEntity findCarByMarca(@PathVariable String marca) {
        return ResponseEntity.status(HttpStatus.OK).body(masinaService.findByMarca(marca));
    }

    @GetMapping("/find")
    public ResponseEntity findByMarcaReqParam(@RequestParam String marca) {
        return ResponseEntity.status(HttpStatus.OK).body(masinaService.findByMarca(marca));
    }

    @DeleteMapping("/{id}")
    public Masina deleteMasinaById(@PathVariable Long id){
        return  masinaService.deleteMasina(id);
    }
}
