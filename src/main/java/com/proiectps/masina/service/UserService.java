package com.proiectps.masina.service;


import com.proiectps.masina.DTO.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    void delete(Long id);

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO login(String username, String password);

}
