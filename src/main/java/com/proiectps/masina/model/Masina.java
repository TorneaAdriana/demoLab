package com.proiectps.masina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Masina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marca;
    private int pret;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User proprietar;

}
