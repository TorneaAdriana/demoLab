package com.proiectps.masina.repository;

 ;
 import com.proiectps.masina.model.Componenta;
 import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;

@Repository
public interface ComponentaRepository extends CrudRepository<Componenta, Long> {
}
