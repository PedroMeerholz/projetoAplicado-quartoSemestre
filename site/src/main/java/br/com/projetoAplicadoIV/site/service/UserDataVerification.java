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
        return verifyCpf(newUser.getCpf()) || verifyEmail(newUser.getEmail()) || verifyName(newUser.getName()) || verifyPassword(newUser.getPassword());
    }

    public boolean validateUpdate(UpdateUserDTO user) {
        //True is returned if there is a problem.
        return verifyEmail(user.getEmail()) || verifyName(user.getName()) || verifyPassword(user.getPassword());
    }

    private boolean verifyCpf(String cpf) {
        //True is returned if there is a problem.
        if(isEmptyString(cpf)) {
            addToMessage("Field CPF can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean verifyCpfLength(String cpf) {
        if(cpf.length() != 11) {
            addToMessage("CPF has to have 11 characters with no spaces.");
            return true;
        }
        return false;
    }

    private boolean verifyCpfValid(String cpf) {

        return true;
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
