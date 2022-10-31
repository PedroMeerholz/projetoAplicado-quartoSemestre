package br.com.projetoAplicadoIV.site.service;

import br.com.projetoAplicadoIV.site.entity.dto.NewUserDTO;
import br.com.projetoAplicadoIV.site.entity.dto.UpdateUserDTO;
import br.com.projetoAplicadoIV.site.utils.CpfUtils;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

@Service
public class UserDataVerification {
    private String message = "";
    private final CpfUtils cpfUtils = new CpfUtils();

    public boolean areFieldsEmpty(NewUserDTO newUser) {
        //True is returned if there is a problem.
        return isCpfEmpty(newUser.getCpf()) || isEmailEmpty(newUser.getEmail()) || isNameEmpty(newUser.getName()) || isPasswordEmpty(newUser.getPassword());
    }

    public boolean areFieldsEmpty(UpdateUserDTO user) {
        //True is returned if there is a problem.
        return isEmailEmpty(user.getEmail()) || isNameEmpty(user.getName()) || isPasswordEmpty(user.getPassword());
    }

    public boolean checkValidInfo(NewUserDTO newUser) {
        return isCpfLengthValid(newUser.getCpf()) && isCpfValid(newUser.getCpf()) && isPasswordLengthValid(newUser.getPassword());
    }

    public boolean checkValidInfo(UpdateUserDTO newUser) {
        return isPasswordLengthValid(newUser.getPassword());
    }

    private boolean isCpfEmpty(String cpf) {
        //True is returned if there is a problem.
        if(isEmptyString(cpf)) {
            addToMessage("Field CPF can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean isCpfLengthValid(String cpf) {
        //Returns true if valid.
        if(cpfUtils.verifyCpfLength(cpf)) return true;
        addToMessage("CPF has to have 11 characters with no spaces.");
        return false;
    }

    private boolean isCpfValid(String cpf) {
        //Returns true if valid.
        if(cpfUtils.validateCpf(cpf)) return true;
        addToMessage("Cpf is invalid.");
        return false;
    }

    private boolean isEmailEmpty(String email) {
        //True is returned if there is a problem.
        if(isEmptyString(email)) {
            addToMessage("Field EMAIL can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean isNameEmpty(String name) {
        //True is returned if there is a problem.
        if(isEmptyString(name)) {
            addToMessage("Field NAME can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean isPasswordEmpty(String password) {
        //True is returned if there is a problem.
        if(isEmptyString(password)) {
            addToMessage("Field PASSWORD can't be null.\n");
            return true;
        }
        return false;
    }

    private boolean isPasswordLengthValid(String password) {
        //True is returned if it is valid.
        if(password.length() >= 8) {
            return true;
        }
        addToMessage("Password has to have 8 or more characters.");
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
