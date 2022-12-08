package com.informabr.api.service;

import com.informabr.api.entity.User;
import com.informabr.api.entity.dto.GetTokenDTO;
import com.informabr.api.entity.dto.GetUserDTO;
import com.informabr.api.entity.dto.NewUserDTO;
import com.informabr.api.entity.dto.UpdateUserDTO;
import com.informabr.api.repository.UserRepository;
import com.informabr.api.utils.generator.IdGenerator;
import com.informabr.api.utils.generator.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDataVerification userDataVerification;
    private final TokenService tokenService;
    private final IdGenerator idGenerator;
    public UserService(UserRepository userRepository, UserDataVerification userDataVerification, TokenService tokenService, IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.userDataVerification = userDataVerification;
        this.tokenService = tokenService;
        this.idGenerator = idGenerator;
    }

    public String saveUser(NewUserDTO newUser, String token, String cpf) {
        if(tokenService.verifyToken(cpf, token)) {
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
                user.setPassword(newUser.getPassword());
                user.setToken(TokenGenerator.generateToken());

                userRepository.save(user);

                return "Successfully created user.";
            }
        } else {
            return "Your authentication token is wrong. Please verify.";
        }
        return userDataVerification.getMessage();
    }

    public String updateUser(UpdateUserDTO updatedUser, String cpf, String token) {
        if(tokenService.verifyToken(cpf, token)) {
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
        } else {
            return "Your autentication token in wrong. Please verify.";
        }
        return "User with CPF '" + cpf + "' does not exist.";
    }

    public GetUserDTO getUser(String cpf, String token) {
        Optional<User> user = checkForUserByCPF(cpf);

        if(tokenService.verifyToken(cpf, token)) {
            if(user.isPresent()) {
                User presentUser = user.get();
                GetUserDTO getUserDTO = new GetUserDTO();
                getUserDTO.setName(presentUser.getName());
                getUserDTO.setCpf(presentUser.getCpf());
                getUserDTO.setEmail(presentUser.getEmail());
                return getUserDTO;
            }
        }
        return new GetUserDTO();
    }

    public String getToken(String cpf) {
        return tokenService.getToken(cpf);
    }

    public String deleteUser(String cpf, String token) {
        if(tokenService.verifyToken(cpf, token)) {
            Optional<User> user = checkForUserByCPF(cpf);

            if(user.isPresent()) {
                userRepository.delete(user.get());
                return "User deleted successfully.";
            }
        } else {
            return "Your authentication token is wrong. Please verify.";
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
