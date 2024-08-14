package exercises;

import java.util.Scanner;

public class exercise_logic3 {
    public static void main(String[] args) {
        //Read 4 values and print the diference between the product of the first two 
        //and the product of the last two
        int a, b, c, d;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Type 4 values: ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        System.out.println("Diference = " + (a * b - c * d));
    }
}
