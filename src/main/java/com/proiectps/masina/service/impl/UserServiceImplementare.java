package com.proiectps.masina.service.impl;

import com.proiectps.masina.DTO.UserDTO;
import com.proiectps.masina.mapper.UserMapper;
import com.proiectps.masina.model.User;
import com.proiectps.masina.repository.UserRepository;
import com.proiectps.masina.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
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

    @Override
    public UserDTO login(String username, String password) {
        try {
            UserDTO user1 = userMapper.mapModelToDto(userRepository.findByUsername(username));
            System.out.println("User 1" + user1.getUsername());


            System.out.println(username + password);

            if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
                return user1;
            }


            final User user = userRepository.findByUsernameAndPassword(username, password)
                    .<EntityNotFoundException>orElseThrow(()
                            ->
                    {
                        throw new EntityNotFoundException("Cannot find");

                    });

            //  return userMapper.toDTO(user);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return null;
    }
}
