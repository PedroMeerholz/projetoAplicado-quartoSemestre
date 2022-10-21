package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.User;
import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.entity.dto.UpdateUserDTO;
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
        if(userDataVerification.checkEmptyFields(newUser)) {
            return userDataVerification.getMessage();
        } else {
            if(checkForUser(newUser.getCpf()).isPresent()) {
                return "User already exists.";
            }

            User user = new User();
            user.setCpf(newUser.getCpf());
            user.setEmail(newUser.getEmail());
            user.setName(newUser.getName());
            user.setPassword(newUser.getPassword());

            userRepository.save(user);
        }
        return "Success";
    }

    public String updateUser(UpdateUserDTO user, Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        return "";
    }

    public String deleteUser(String cpf) {
        Optional<User> user = checkForUser(cpf);

        if(user.isPresent()) {
            userRepository.delete(user.get());
            return "User deleted successfully.";
        }

        return "User with CPF " + cpf + " does not exist.";
    }

    public Optional<User> checkForUser(String cpf) {
        Optional<User> user = userRepository.findByCPF(cpf);
        return user;
    }
}
