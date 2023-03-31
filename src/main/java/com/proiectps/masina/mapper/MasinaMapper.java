package com.proiectps.masina.mapper;

import com.proiectps.masina.DTO.MasinaDTO;
import com.proiectps.masina.model.Masina;
import org.springframework.stereotype.Component;

@Component
public class MasinaMapper {

    public static MasinaDTO mapModelToDto(Masina masina){
        MasinaDTO masinaDTO=new MasinaDTO();
        masinaDTO.setId(masina.getId());
        masinaDTO.setMarca(masina.getMarca());
        masinaDTO.setPret(masina.getPret());

        return masinaDTO;
    }

    public static Masina mapDtoToModel(MasinaDTO masinaDTO){
        Masina masina=new Masina();
        masina.setMarca(masinaDTO.getMarca());
        masina.setId(masinaDTO.getId());
        masina.setPret(masinaDTO.getPret());

        return masina;
    }
}
