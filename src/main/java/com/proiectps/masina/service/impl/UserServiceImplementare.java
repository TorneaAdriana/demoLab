package com.proiectps.masina.service.impl;

import com.proiectps.masina.DTO.UserDTO;
import com.proiectps.masina.mapper.UserMapper;
import com.proiectps.masina.model.User;
import com.proiectps.masina.repository.UserRepository;
import com.proiectps.masina.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementare implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImplementare(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public void delete(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() ->
                {
                    throw new EntityNotFoundException("Nu se poate gasi user-ul cu ID-ul: " + id);
                });

        userRepository.delete(user);

    }

    @Override
    public List<UserDTO> findAll() {

        return userRepository.findAll().
                stream().
                map(userMapper::mapModelToDto).
                collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()
                        ->
                        new IllegalArgumentException("Id invalid"));
        return userMapper.mapModelToDto(user);
    }
}
