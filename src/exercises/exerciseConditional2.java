package exercises;

import java.util.Scanner;

public class exerciseConditional2 {
    public static void main(String[] args) {
        //Read a number and indicate if it is even or odd
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a number: ");
        int x = sc.nextInt();

        if (x % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
