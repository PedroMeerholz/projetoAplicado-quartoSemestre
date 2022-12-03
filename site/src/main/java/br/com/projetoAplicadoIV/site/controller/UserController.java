package br.com.projetoAplicadoIV.site.controller;

import br.com.projetoAplicadoIV.site.entity.dto.GetUserDTO;
import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.entity.dto.UpdateUserDTO;
import br.com.projetoAplicadoIV.site.service.UserService;
import br.com.projetoAplicadoIV.site.utils.generator.TokenGenerator;
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

    @GetMapping("/get/{cpf}")
    public GetUserDTO getUser(@PathVariable("cpf") String cpf, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userService.getUser(cpf, token);
    }

    @DeleteMapping("/delete/{cpf}")
    public String deleteUser(@PathVariable("cpf") String cpf, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return userService.deleteUser(cpf, token);
    }

}