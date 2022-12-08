package com.informabr.api.controller;

import com.informabr.api.entity.dto.GetTokenDTO;
import com.informabr.api.entity.dto.GetUserDTO;
import com.informabr.api.entity.dto.NewUserDTO;
import com.informabr.api.entity.dto.UpdateUserDTO;
import com.informabr.api.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/{cpf}")
    public String createUser(@RequestBody NewUserDTO newUser, @PathVariable("cpf") String cpf, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userService.saveUser(newUser, token, cpf);
    }

    @PutMapping("/update/{cpf}")
    public String updateUser(@RequestBody UpdateUserDTO prevUser, @PathVariable("cpf") String cpf, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userService.updateUser(prevUser, cpf, token);
    }

    @GetMapping(value="/get/{cpf}", produces = "application/json")
    public GetUserDTO getUser(@PathVariable("cpf") String cpf, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userService.getUser(cpf, token);
    }

    @GetMapping(value="/get/token/{cpf}", produces = "application/json")
    public String getToken(@PathVariable("cpf") String cpf) {
        return userService.getToken(cpf);
    }

    @DeleteMapping("/delete/{cpf}")
    public String deleteUser(@PathVariable("cpf") String cpf, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userService.deleteUser(cpf, token);
    }

}