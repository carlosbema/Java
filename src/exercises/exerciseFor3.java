package exercises;

import java.util.Scanner;

public class exerciseFor3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the quantity: ");
        int quantity = sc.nextInt();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Type three values: ");
            double firstValue = sc.nextDouble();
            double secondValue = sc.nextDouble();
            double thirdValue = sc.nextDouble();

            double average = (firstValue * 2 + secondValue * 3 + thirdValue * 5) / 10;
            String formattedAverage = String.format("%.1f", average);
            System.out.println(formattedAverage);
        }
        sc.close();
    }
}
