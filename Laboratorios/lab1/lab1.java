package Laboratorios.lab1;

import java.util.Arrays;

public class lab1 {
    public static void main(String[] args) {
        System.out.println(prefixo("tesoura", "tesouro", "tesoubo"));
    }

    public static String prefixo(String... args) {
        System.out.println(Arrays.toString(args));
        String base = args[0];
        String finalPrefix = "";

        for (String palavra : args) {
            StringBuilder newBase = new StringBuilder();
            int position = 0;

            for (char letra : palavra.toCharArray()) {
                if (letra == base.charAt(position)) {
                    newBase.append(letra);
                    position++;
                } else {
                    break;
                }
            }
            finalPrefix = newBase.toString();
        }
        return finalPrefix;
    }
}

