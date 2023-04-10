package com.proiectps.masina.controller;

import com.proiectps.masina.DTO.UserDTO;
import com.proiectps.masina.model.Account;
import com.proiectps.masina.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam Long Id) {
        userService.delete(Id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserDTO> findAll() {
        return userService.findAll();
    }


    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody Account account) {
        UserDTO user = userService.login(account.getUsername(), account.getPassword());

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
