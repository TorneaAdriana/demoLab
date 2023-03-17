package com.proiectps.masina.service;


import com.proiectps.masina.model.Masina;
import org.springframework.stereotype.Component;

@Component
public interface MasinaService {

    Masina findByMarca(String marca);
    Masina updateMasina(Masina masina);

}
