package lessons;

import java.util.Locale;
import java.util.Scanner;

public class entrada {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String x = sc.next();
            System.out.println("Valor " + x);

            int y = sc.nextInt();
            System.out.println("Valor " + y);

            Locale.setDefault(Locale.US);
            double z = sc.nextDouble();
            System.out.printf("Valor %.2f%n", z);

            char a;
            a = sc.next().charAt(0);
            System.out.println("Valor " + a);
        }
    }
}
