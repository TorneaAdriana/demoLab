package com.proiectps.masina.mapper;

import com.proiectps.masina.DTO.UserDTO;
import com.proiectps.masina.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO mapModelToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());

        return userDTO;
    }
}
