package Laboratorios.lab1;

import java.util.Arrays;
import java.util.Random;

public class lab1InstanceGenerator {
    public static void main(String[] args) {
        int arraySize = 50;
        int stringSize = 4;

        String[] randomStrings = new String[arraySize];
        Random random = new Random();

        String stringChars = "ABCD";

        for (int i = 0; i < arraySize; i++) {
            StringBuilder randomString = new StringBuilder(arraySize);

            for (int j = 0; j < stringSize; j++) {
                int randomIndex = random.nextInt(stringChars.length());
                randomString .append(stringChars.charAt(randomIndex));
            }

            randomStrings[i] = randomString.toString();
        }

        String arrayAspas = Arrays.toString(
            Arrays.stream(randomStrings).map(randomString -> "\"" + randomString + "\"").toArray(String[]::new)
        );

        System.out.println(arrayAspas);
    }
}
