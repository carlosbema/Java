package exercises;

import java.util.Scanner;

public class exerciseLogic6 {
    public static void main(String[] args) {
        //Read 3 values and print the area of the triangle, the area of the circle, the area of the trapezium, the area of the square and the area of the rectangle
        double a, b, c;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 3 values: ");
        System.out.println("Digite 3 valores: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        
        System.out.println("TRIANGULO: " + String.format("%.3f", (a * c)/2));
        System.out.println("CIRCULO: " + String.format("%.3f", 3.14159 * (c * c)));
        System.out.println("TRAPEZIO: " + String.format("%.3f", ((a + b) * c)/2));
        System.out.println("QUADRADO: " + String.format("%.3f", b * b));
        System.out.println("ReTANGULO: " + String.format("%.3f", a * b));
    }
}
