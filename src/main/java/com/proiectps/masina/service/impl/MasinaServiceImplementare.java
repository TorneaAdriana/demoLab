package com.proiectps.masina.service.impl;


import com.proiectps.masina.model.Masina;
import com.proiectps.masina.repository.MasinaRepository;
import com.proiectps.masina.service.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
