package com.proiectps.masina.repository;


import com.proiectps.masina.model.Caroserie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaroserieRepository extends CrudRepository<Caroserie,Long> {
}
