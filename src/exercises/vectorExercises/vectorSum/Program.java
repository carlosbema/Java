package exercises.vectorExercises.vectorSum;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Which size vectors do you want? ");
        int vectorSize = sc.nextInt();
        int[] vectorA = new int[vectorSize];
        int[] vectorB = new int[vectorSize];
        int[] sumVectors = new int[vectorSize];

        System.out.println("Type vector A values: ");
        for (int i = 0; i < vectorA.length; i++){
            vectorA[i] = sc.nextInt();
        }

        System.out.println("Type vector B values: ");
        for (int i = 0; i < vectorB.length; i++){
            vectorB[i] = sc.nextInt();
        }

        System.out.println("Resulting vector: ");
        for (int i = 0; i < sumVectors.length; i++){
            sumVectors[i] = vectorA[i] + vectorB[i];
            System.out.println(sumVectors[i]);
        }
        sc.close();
    }
}
