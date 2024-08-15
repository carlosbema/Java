package exercises;

import java.util.Scanner;

public class exercise_for4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the quantity: ");
        int quantity = sc.nextInt();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Type the numerator: ");
            int numerator = sc.nextInt();
            System.out.println("Type the denominator: ");
            int denominator = sc.nextInt();
            switch (denominator){
                case 0:
                    System.out.println("Division by zero!");
                    break;
                default:
                    System.out.println("Quotient = " + numerator / denominator);
                    break;
            }
        }
    sc.close();
    }
}
