package lessons.static_.program;

import java.util.Scanner;

import lessons.static_.util.calculator;

public class program {

    public static void main(String[] args) {
        System.out.println("Enter radius: ");
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        double c = calculator.circumference(radius);
        double v = calculator.volume(radius);

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);

        sc.close();
    }
}
