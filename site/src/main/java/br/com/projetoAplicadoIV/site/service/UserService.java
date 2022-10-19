package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(NewUserDTO newUser) {

    }
}
