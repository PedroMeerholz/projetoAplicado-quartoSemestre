package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserDataVerification {
    private String message = "";
    public boolean checkEmptyFields(NewUserDTO newUser) {
        if(verifyCpf(newUser.getCpf()) || verifyEmail(newUser.getEmail()) || verifyName(newUser.getName()) || verifyPassword(newUser.getPassword())) {
            return true;
        }
        return false;
    }

    private boolean verifyCpf(String cpf) {
        if(isEmptyString(cpf)) {
            addToMessage("Field CPF can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean verifyEmail(String email) {
        if(isEmptyString(email)) {
            addToMessage("Field EMAIL can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean verifyName(String name) {
        if(isEmptyString(name)) {
            addToMessage("Field NAME can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean verifyPassword(String password) {
        if(isEmptyString(password)) {
            addToMessage("Field PASSWORD can't be null.\n");
            return true;
        }
        return false;
    }

    public boolean isEmptyString(String string) {
        if(string == null || string.trim().isBlank()) {
            return true;
        }
        return false;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addToMessage(String message) {
        this.message += message;
    }

    public String getMessage() {
        String msg = message;
        setMessage("");
        return msg;
    }
}
