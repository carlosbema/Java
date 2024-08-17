package exercises;

import java.util.Scanner;

public class exerciseWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fuelType = 0;
        int quantityAlcohol = 0;
        int quantityGasoline = 0;
        int quantityDiesel = 0;

        while (fuelType != 4) {
            System.out.println("Type the fuel type: ");
            fuelType = sc.nextInt();
            switch (fuelType) {
                case 1:
                    quantityAlcohol++;
                    break;
                case 2:
                    quantityGasoline++;
                    break;
                case 3:
                    quantityDiesel++;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid fuel type. Try again: ");
                    break;
            }
        }
        System.out.println("Thank you");
        System.out.println("Alcohol: " + quantityAlcohol);
        System.out.println("Gasoline: " + quantityGasoline);
        System.out.println("Diesel: " + quantityDiesel);
        sc.close();
    }
}
