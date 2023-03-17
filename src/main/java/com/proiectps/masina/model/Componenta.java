package com.proiectps.masina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Componenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
