package com.proiectps.masina.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MasinaDTO {

    private Long id;
    private String marca;
    private int pret;
}
