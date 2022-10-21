package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.User;
import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDataVerification userDataVerification;

    public UserService(UserRepository userRepository, UserDataVerification userDataVerification) {
        this.userRepository = userRepository;
        this.userDataVerification = userDataVerification;
    }

    public String saveUser(NewUserDTO newUser) {
        Optional<User> existentUser = userRepository.findByCPF(newUser.getCpf());

        if(existentUser.isPresent()) {
            return "User already exists.";
        }

        if(userDataVerification.checkEmptyFields(newUser)) {
            return userDataVerification.getMessage();
        } else {
            User user = new User();
            user.setCpf(newUser.getCpf());
            user.setEmail(newUser.getEmail());
            user.setName(newUser.getName());
            user.setPassword(newUser.getPassword());

            userRepository.save(user);
        }
        return "Success";
    }
}
