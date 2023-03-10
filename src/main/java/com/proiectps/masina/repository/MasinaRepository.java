package com.proiectps.masina.repository;

import com.proiectps.masina.model.Masina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasinaRepository extends CrudRepository<Masina, Long> {
}
