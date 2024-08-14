package exercises;

import java.util.Scanner;

public class exercise_conditional3 {
    public static void main(String[] args) {
        //Read 2 numbers and indicate if they are multiples
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 2 numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x % y == 0 || y % x == 0) {
            System.out.println("Are multiples");
        } else {
            System.out.println("Not multiples");
        }
    }
}