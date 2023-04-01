package com.proiectps.masina.repository;

import com.proiectps.masina.DTO.MasinaDTO;
import com.proiectps.masina.model.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasinaRepository extends JpaRepository<Masina, Long> {
    MasinaDTO findFirstByMarca(String marca);

    Masina findAllByMarca(String marca);

    Masina findFirstByIdAndMarca(Long id, String marca);

    Optional<Masina> findByMarca(String marca);

}
