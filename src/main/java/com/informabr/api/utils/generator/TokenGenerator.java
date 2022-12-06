package com.informabr.api.utils.generator;

import java.util.Random;

public class TokenGenerator {

    private static Long generateLong() {
        Random random = new Random();
        return random.nextLong();
    }

    private static String generateString() {
        String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String generatedString = "";
        Random random = new Random();
        int cont = 0;
        while(cont < 20) {
            generatedString = generatedString + alfabeto[random.nextInt(0, 26)];
            cont+=1;
        }
        return generatedString;
    }

    public static String generateToken() {
        return generateString() + generateLong();
    }
}
