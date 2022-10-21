package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataVerification {
    private String message = "";
    public boolean checkEmptyFields(NewUserDTO newUser) {
        boolean var = false;
        if(isEmptyString(newUser.getCpf())) {
            addToMessage("Field CPF can't be null.\n");
            var = true;
        }
        if(isEmptyString(newUser.getEmail())) {
            addToMessage("Field EMAIL can't be null.\n");
            var = true;
        }
        if(isEmptyString(newUser.getName())) {
            addToMessage("Field NAME can't be null.\n");
            var = true;
        }
        if(isEmptyString(newUser.getPassword())) {
            addToMessage("Field PASSWORD can't be null.\n");
            var = true;
        }
        return var;
    }

    public boolean isEmptyString(String string) {
        if(string.trim().isBlank()) {
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
