package com.proiectps.masina.controller;

import com.proiectps.masina.DTO.UserDTO;
import com.proiectps.masina.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public void delete(@RequestParam Long Id)
    {
        userService.delete(Id);
    }

    @RequestMapping(value="/all",method =RequestMethod.GET)
    public List<UserDTO> findAll()
    {
        return userService.findAll();
    }


}
