package br.com.projetoAplicadoIV.site.utils;

public class CpfUtils {
    private String message = "";
    public boolean verifyCpfLength(String cpf) {
        if(cpf.length() != 11) return true;
        return false;
    }

    public boolean verifyCpf(String cpf) {
        int soma = 0;
        double uh = 0.0;
        double resto = 0.0;
        double restoInt = 0;

        for(int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        uh = soma * 10 / 11;
        resto = soma * 10 % 11;
        if(resto >= 10) {
            resto = 0;
            restoInt = 0;
        }

        restoInt = Math.round(resto);

        System.out.println(uh);
        System.out.println(resto);



        return false;
    }

    public boolean validateFirstDigit() {
        return true;
    }

    public boolean validateSecondDigit() {
        return true;
    }

    public void addToMessage(String message) {
        this.message += message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String msg = message;
        setMessage("");
        return msg;
    }
}
