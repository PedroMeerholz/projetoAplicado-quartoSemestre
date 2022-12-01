package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.dto.GetTokenDTO;
import br.com.projetoAplicadoIV.site.repository.UserRepository;
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
        if(equals(token) == equals(paramToken)) {
            return true;
        } else {
            return false;
        }
    }
}
