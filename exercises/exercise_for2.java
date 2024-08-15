package exercises;

import java.util.Scanner;

public class exercise_for2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the quantity: ");
        int quantity = sc.nextInt();
        int countIn = 0;
        int countOut = 0;
        for (int i = 0; i < quantity; i++) {
            System.out.println("Type a number: ");
            int y = sc.nextInt();
            if (10 <= y && y <= 20) {
                countIn += 1;
            } else {
                countOut += 1;
            }
        }
        System.out.println(countIn + " in range of 10 and 20");
        System.out.println(countOut + " out of range of 10 and 20");
        sc.close();
    }
}
