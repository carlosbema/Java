package exercises.generalBasics;

import java.util.Scanner;

public class exerciseLogic2 {
    public static void main(String[] args) {
        //Read the value of a circle radius and print its area
        System.out.println("Type the circle radius: ");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        double raio = sc.nextDouble();
        double area = Math.PI * Math.pow(raio, 2);
        System.out.println("Area = " + area);
    }
}
