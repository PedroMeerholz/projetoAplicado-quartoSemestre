package br.com.projetoAplicadoIV.site.controller;

import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.entity.dto.UpdateUserDTO;
import br.com.projetoAplicadoIV.site.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody NewUserDTO newUser) {
        return userService.saveUser(newUser);
    }

    @PutMapping("/update/{cpf}")
    public String updateUser(@RequestBody UpdateUserDTO prevUser, @PathVariable("cpf") String cpf) {
        return userService.updateUser(prevUser, cpf);
    }

    @DeleteMapping("/delete/{cpf}")
    public String deleteUser(@PathVariable("cpf") String cpf) {
        return userService.deleteUser(cpf);
    }
}