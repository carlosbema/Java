package exercises;

import java.util.Scanner;

public class exercise_logic5 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        //Read the item number, quantity and unity price and print the total
        int itemNumber1, quantity1, itemNumber2, quantity2;
        double unityPrice1, unityPrice2;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the item number 1: ");
        itemNumber1 = sc.nextInt();
        System.out.println("Type the quantity 1: ");
        quantity1 = sc.nextInt();
        System.out.println("Type the unity price 1: ");
        unityPrice1 = sc.nextDouble();
        System.out.println("Type the item number 2: ");
        itemNumber2 = sc.nextInt();
        System.out.println("Type the quantity 2: ");
        quantity2 = sc.nextInt();
        System.out.println("Type the unity price 2: ");
        unityPrice2 = sc.nextDouble();
        System.out.println("TOTAL = U$ " + String.format("%.2f", (quantity1 * unityPrice1 + quantity2 * unityPrice2)));
    }
}
