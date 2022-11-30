package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.User;
import br.com.projetoAplicadoIV.site.entity.dto.GetUserDTO;
import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.entity.dto.UpdateUserDTO;
import br.com.projetoAplicadoIV.site.repository.UserRepository;
import br.com.projetoAplicadoIV.site.utils.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDataVerification userDataVerification;
    private final IdGenerator idGenerator;
    public UserService(UserRepository userRepository, UserDataVerification userDataVerification, IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.userDataVerification = userDataVerification;
        this.idGenerator = idGenerator;
    }

    public String saveUser(NewUserDTO newUser) {
        if(userDataVerification.areFieldsEmpty(newUser)) {
            return userDataVerification.getMessage();
        }
        if(userDataVerification.checkValidInfo(newUser)) {
            if(checkForUserByCPF(newUser.getCpf()).isPresent() || checkForUserByEmail(newUser.getEmail()).isPresent()) {
                return "User already exists.";
            }
            User user = new User();
            user.setId(idGenerator.getNewId());
            user.setCpf(newUser.getCpf());
            user.setEmail(newUser.getEmail());
            user.setName(newUser.getName());

            userRepository.save(user);

            return "Successfully created user.";
        }
        return userDataVerification.getMessage();
    }

    public String updateUser(UpdateUserDTO updatedUser, String cpf) {
        if(userDataVerification.areFieldsEmpty(updatedUser)) {
            return userDataVerification.getMessage();
        }

        Optional<User> existingUser = checkForUserByCPF(cpf);

        if(existingUser.isPresent()) {
            if(userDataVerification.areFieldsEmpty(updatedUser)) {
                return userDataVerification.getMessage();
            }
            User user = existingUser.get();
            user.setEmail(updatedUser.getEmail().trim());
            user.setName(updatedUser.getName().trim());

            userRepository.save(user);
            return "User updated successfully.";
        }
        return "User with CPF '" + cpf + "' does not exist.";
    }

    public GetUserDTO getUser(String cpf) {
        Optional<User> user = checkForUserByCPF(cpf);

        if(user.isPresent()) {
            User presentUser = user.get();
            GetUserDTO getUserDTO = new GetUserDTO();
            getUserDTO.setName(presentUser.getName());
            getUserDTO.setCpf(presentUser.getCpf());
            getUserDTO.setEmail(presentUser.getEmail());
            return getUserDTO;
        } else {
            return new GetUserDTO();
        }
    }

    public String deleteUser(String cpf) {
        Optional<User> user = checkForUserByCPF(cpf);

        if(user.isPresent()) {
            userRepository.delete(user.get());
            return "User deleted successfully.";
        }
        return "User with CPF " + cpf + " does not exist.";
    }

    public Optional<User> checkForUserByCPF(String cpf) {
        return userRepository.findByCPF(cpf);
    }

    public Optional<User> checkForUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
