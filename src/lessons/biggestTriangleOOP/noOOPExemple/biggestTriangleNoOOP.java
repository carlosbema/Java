package lessons.biggestTriangleOOP.noOOPExemple;

import java.util.Locale;
import java.util.Scanner;

public class biggestTriangleNoOOP {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the measures of triangle X: ");

        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();

        double pX = (x + y + z) / 2;
        double areaX = Math.sqrt(pX * (pX - x) * (pX - y) * (pX - z));

        System.out.println("Enter the measures of triangle Y: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double pY = (a + b + c) / 2;
        double areaY = Math.sqrt(pY * (pY - a) * (pY - b) * (pY - c));

        System.out.printf("Triangle X area: %.4f%n", areaX);
        System.out.printf("Triangle Y area: %.4f%n", areaY);
        if (areaX > areaY) {
            System.out.println("Larger area: X");
        } else {
            System.out.println("Larger area: Y");
        }
        sc.close();
    }
}
