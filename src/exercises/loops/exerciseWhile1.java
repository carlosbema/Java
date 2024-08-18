package exercises.loops;

import java.util.Scanner;

public class exerciseWhile1 {
    public static void main(String[] args) {
        int password = 2002;
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the password: ");
        int userTry = sc.nextInt();
        while (userTry != password) {
            System.out.println("Invalid password. Try again: ");
            userTry = sc.nextInt();
        }
        System.out.println("Access granted!");
        sc.close();
    }
}
