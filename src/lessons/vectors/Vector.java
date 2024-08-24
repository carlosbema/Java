package lessons.vectors;

import java.util.Locale;
import java.util.Scanner;

public class Vector {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the vector size: ");
        int n = sc.nextInt();
        double[] vect = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter a number: ");
            vect[i] = sc.nextDouble();
        }

        for (int i = 0 ; i < n; i++) {
            System.out.printf("%.1f%n", vect[i]);
        }
        System.out.println(vect);
        sc.close();
    }
}
