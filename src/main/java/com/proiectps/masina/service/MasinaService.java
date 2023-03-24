package com.proiectps.masina.service;


import com.proiectps.masina.model.Masina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MasinaService {

    Masina findByMarca(String marca);
    Masina updateMasina(Masina masina);

    Masina findAllByMarca(String marca);

    List<Masina> findAll();
    Masina findById(Long id);
    Masina findFirstByIdAndMarca(Long id, String marca) ;
    Masina deleteMasina(Long id);

}
