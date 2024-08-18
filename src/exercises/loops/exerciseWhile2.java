package exercises.loops;

import java.util.Scanner;

public class exerciseWhile2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer x = 0;
        Integer y = 0;
        while (x != null && y != null) {
            System.out.println("Type X-axis: ");
            x = sc.nextInt();
            System.out.println("Type Y-axis: ");
            y = sc.nextInt();
            if (x > 0 && y > 0) {
                System.out.println("Q1");
            } else if (x < 0 && y > 0) {
                System.out.println("Q2");
            } else if (x < 0 && y < 0) {
                System.out.println("Q3");
            } else if (x > 0 && y < 0) {
                System.out.println("Q4");
            } else if (y == 0 && x == 0){
                System.out.println("Origin");
            }else if (x == 0) {
                System.out.println("Y-axis");
            } else if (y == 0) {
                System.out.println("X-axis");
            } else {
                System.out.println("Error");
            }
        }sc.close();
    }
}
