package com.proiectps.masina.service.impl;


import com.proiectps.masina.DTO.MasinaDTO;
import com.proiectps.masina.mapper.MasinaMapper;
import com.proiectps.masina.model.Masina;
import com.proiectps.masina.model.User;
import com.proiectps.masina.repository.MasinaRepository;
import com.proiectps.masina.repository.UserRepository;
import com.proiectps.masina.service.MasinaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasinaServiceImplementare implements MasinaService {


    private final MasinaRepository masinaRepository;

    @Autowired
    private UserRepository userRepository;


    private final MasinaMapper masinaMapper;

    public MasinaServiceImplementare(MasinaRepository masinaRepository, UserRepository userRepository, MasinaMapper masinaMapper) {
        this.masinaRepository = masinaRepository;
        this.userRepository = userRepository;
        this.masinaMapper = masinaMapper;
    }

    @Override
    public MasinaDTO findByMarca(String marca) {
        final Masina masina = masinaRepository.findByMarca(marca)
                .orElseThrow(()
                        -> {
                    throw new EntityNotFoundException("Can not find book ");
                });

        return MasinaMapper.mapModelToDto(masina);
    }

    @Override
    public Masina updateMasina(Masina masina) {
        Masina updateMasina = masinaRepository.findById(masina.getId()).get();
        updateMasina.setUser(masina.getUser());
        masinaRepository.save(updateMasina);

        return updateMasina;
    }

    @Override
    public Masina findAllByMarca(String marca) {
        return masinaRepository.findAllByMarca(marca);
    }

    @Override
    public List<MasinaDTO> findAll() {
        return masinaRepository.findAll()
                .stream().map(
                        MasinaMapper::mapModelToDto
                ).collect(Collectors.toList());
    }

    @Override
    public Masina findById(Long id) {
        return masinaRepository.findById(id).get();
    }

    @Override
    public Masina findFirstByIdAndMarca(Long id, String marca) {
        Masina masina = masinaRepository.findFirstByIdAndMarca(id, marca);

        return masina;
    }

    @Override
    public Masina deleteMasina(Long id) {
        Masina masina = masinaRepository.findById(id).get();
        masinaRepository.delete(masina);
        return masina;
    }

    @Override
    public Masina updateMasina(MasinaDTO masinaDTO) {

        Masina masina = masinaRepository.findById(masinaDTO.getId()).get();
        User user = userRepository.findById(masinaDTO.getId()).get();
        user.getMasinaList().add(masina);

        return masinaRepository.save(masina);
    }

    @Override
    public MasinaDTO findByIdDTO(Long id) {
        final Masina masina = masinaRepository.findById(id)
                .orElseThrow(()
                        ->
                {
                    throw new EntityNotFoundException("Nu se poate gasi masina cu Id-ul:" + id);
                });

        return masinaMapper.mapModelToDto(masina);
    }
}
