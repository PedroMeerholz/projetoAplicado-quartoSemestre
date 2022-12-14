package com.informabr.api.service;

import com.informabr.api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final UserRepository userRepository;

    public TokenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getToken(String cpf) {
        String token = null;
        if(this.userRepository.getToken(cpf).isPresent()) {
             token = this.userRepository.getToken(cpf).get();
        }
        return token;
    }

    public boolean verifyToken(String cpf, String paramToken) {
        String token = getToken(cpf);
        if(token != null) {
            if(token.equals(paramToken)) {
                return true;
            }
        }
        return false;
    }
}
