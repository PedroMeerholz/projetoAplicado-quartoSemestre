package br.com.projetoAplicadoIV.site.controller;

import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody NewUserDTO newUser) {
        userService.saveUser(newUser);
    }
}