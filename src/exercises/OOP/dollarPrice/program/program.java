package exercises.OOP.dollarPrice.program;

import java.util.Scanner;

import exercises.OOP.dollarPrice.util.dollarConverter;

public class program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dollar price: ");
        double dollarPrice = sc.nextDouble();

        System.out.println("Amount of dollars: ");
        double amountOfDollars = sc.nextDouble();

        double finalPrice = dollarConverter.convert(dollarPrice, amountOfDollars);
        System.out.println("Amount to be paid in reais: " + finalPrice);
        sc.close();
    }
}
