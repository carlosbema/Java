package exercises;

import java.util.Scanner;

public class exercise_for1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a number: ");
        int x = sc.nextInt();
        for (int i = 1; i < x; i = i + 2) {
            System.out.println(i);
        }sc.close();
    }
}
