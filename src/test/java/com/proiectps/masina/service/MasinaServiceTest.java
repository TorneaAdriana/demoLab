package com.proiectps.masina.service;


import com.proiectps.masina.model.Masina;
import com.proiectps.masina.repository.MasinaRepository;
import com.proiectps.masina.service.impl.MasinaServiceImplementare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MasinaServiceTest {

    private static final String MARCA = "Logan";
    private static final String MARCA_NOT = "Marca care nu exista";

    private MasinaServiceImplementare masinaServiceImplementare;

    @Mock
    private MasinaRepository masinaRepository;

    private Masina masina;

    @BeforeEach
    void init() {
        initMocks(this);
        masina = new Masina();
        masina.setMarca(MARCA);
        when(masinaRepository.findFirstByMarca(MARCA)).thenReturn(masina);
    }

    @Test
    void givenExistingMarca_whenFindByMarca_thenFindOne() {

        masinaServiceImplementare = new MasinaServiceImplementare(masinaRepository);

        Masina masina = masinaServiceImplementare.findByMarca(MARCA);

        assertNotNull(masina);
        assertEquals(MARCA, masina.getMarca());
    }

    @Test
    void givenNonExistingMarca_whenFindByMarca_thenThrowException() {
        when(masinaRepository.findFirstByMarca(MARCA_NOT)).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            masinaServiceImplementare.findByMarca(MARCA_NOT);
        });

    }
}
