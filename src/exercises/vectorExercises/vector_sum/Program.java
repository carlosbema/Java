package exercises.vectorExercises.vector_sum;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the number of numbers: ");
        int quantity = sc.nextInt();
        double[] vect = new double[quantity];
        for (int i = 0; i < vect.length; i++){
            System.out.println("Type the " + (i+ 1) + "th number");
            vect[i] = sc.nextInt();
        }

        double sum = 0;

        System.out.print("Valores: ");
        for (int i = 0; i < vect.length; i++){
            System.out.print(vect[i] + " ");
            sum += vect[i];
        }

        System.out.println();
        System.out.println("Soma: " + sum);
        System.out.println("Média: " + sum/vect.length);

        sc.close();
    }
}
