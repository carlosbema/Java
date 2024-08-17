package lessons.loops;

import java.util.Scanner;

public class for_ {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("How many number will you type?");
        int x = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < x; i++) {
            System.out.println("Type the number: ");
            int y = sc.nextInt();
            sum += y;
        }
        System.out.println("Sum = " + sum);
    }
}
