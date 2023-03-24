package com.proiectps.masina.service.impl;


import com.proiectps.masina.model.Masina;
import com.proiectps.masina.repository.MasinaRepository;
import com.proiectps.masina.service.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasinaServiceImplementare implements MasinaService {

    @Autowired
    private MasinaRepository masinaRepository;

    public MasinaServiceImplementare(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    @Override
    public Masina findByMarca(String marca) {
        return masinaRepository.findFirstByMarca(marca);
    }

    @Override
    public Masina updateMasina(Masina masina) {
        Masina updateMasina = masinaRepository.findById(masina.getId()).get();
        updateMasina.setUser(masina.getUser());
        masinaRepository.save(updateMasina);

        return updateMasina;
    }

    @Override
    public Masina findAllByMarca(String marca){
        return masinaRepository.findAllByMarca(marca);
    }

    @Override
    public List<Masina> findAll() {
        List<Masina> masini=(List<Masina>)masinaRepository.findAll();
        return masini;
    }

    @Override
    public Masina findById(Long id) {
        return masinaRepository.findById(id).get();
    }

    @Override
    public Masina findFirstByIdAndMarca(Long id, String marca) {
        Masina masina = masinaRepository.findFirstByIdAndMarca(id,marca);

        return masina;
    }

    @Override
    public Masina deleteMasina(Long id) {
        Masina masina=masinaRepository.findById(id).get();
        masinaRepository.delete(masina);
        return masina;
    }
}
