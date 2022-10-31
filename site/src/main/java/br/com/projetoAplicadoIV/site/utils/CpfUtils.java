package br.com.projetoAplicadoIV.site.utils;

import java.math.BigInteger;
import java.util.Objects;

public class CpfUtils {

    public boolean verifyCpfLength(String cpf) {
        return cpf.length() == 11;
    }

    public boolean validateCpf(String cpf) {
        if(Objects.equals(cpf, "11111111111") || Objects.equals(cpf, "22222222222") ||
                Objects.equals(cpf, "33333333333") || Objects.equals(cpf, "44444444444") ||
                Objects.equals(cpf, "55555555555") || Objects.equals(cpf, "66666666666") ||
                Objects.equals(cpf, "77777777777") || Objects.equals(cpf, "88888888888") ||
                Objects.equals(cpf, "99999999999")) return false;

        if(validateFirstDigit(cpf)) {
            return validateSecondDigit(cpf);
        }
        return false;
    }

    private boolean validateFirstDigit(String cpf) {
        int FIRST_VERIF_VALUE = 9; // Used to verify the digits and as the string indexes.
        return validateDigit(cpf, FIRST_VERIF_VALUE);
    }

    private boolean validateSecondDigit(String cpf) {
        int SECOND_VERIF_VALUE = 10; // Used to verify the digits and as the string indexes.
        return validateDigit(cpf, SECOND_VERIF_VALUE);
    }

    private boolean validateDigit(String cpf, int counter) {
        int soma = 0;
        double resto;

        for(int i = 0; i < counter; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * ((counter + 1) - i);
        }

        resto = soma * 10 % 11;
        resto = resto >= 10 ? 0 : resto;

        return Character.getNumericValue(cpf.charAt(counter)) == resto;
    }
}
