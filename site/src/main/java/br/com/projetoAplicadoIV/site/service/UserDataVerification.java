package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.entity.dto.UpdateUserDTO;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

@Service
public class UserDataVerification {
    private String message = "";
    public boolean checkEmptyFields(NewUserDTO newUser) {
        //True is returned if there is a problem.
        if(verifyCpf(newUser.getCpf()) || verifyEmail(newUser.getEmail()) || verifyName(newUser.getName()) || verifyPassword(newUser.getPassword())) {
            System.out.println("Deez");
            return true;
        }
        return false;
    }

    public boolean validateUpdate(UpdateUserDTO user) {
        //True is returned if there is a problem.
        if(verifyEmail(user.getEmail()) || verifyName(user.getName()) || verifyPassword(user.getPassword())) {
            return true;
        }
        return false;
    }

    private boolean verifyCpf(String cpf) {
        //True is returned if there is a problem.
        if(isEmptyString(cpf)) {
            addToMessage("Field CPF can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean verifyEmail(String email) {
        //True is returned if there is a problem.
        if(isEmptyString(email)) {
            addToMessage("Field EMAIL can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean verifyName(String name) {
        //True is returned if there is a problem.
        if(isEmptyString(name)) {
            addToMessage("Field NAME can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean verifyPassword(String password) {
        //True is returned if there is a problem.
        if(isEmptyString(password)) {
            addToMessage("Field PASSWORD can't be null.\n");
            return true;
        }
        return false;
    }

    public boolean isEmptyString(String string) {
        //True is returned if it is null
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
