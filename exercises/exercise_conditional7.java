package exercises;

import java.util.Scanner;

public class exercise_conditional7 {
    public static void main(String[] args) {
        //receive 2 coordinates and print the quadrant in which they are
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the coordinates: ");

        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x > 0 && y > 0){
            System.out.println("Q1");
        }
        else if(x < 0 && y > 0){
            System.out.println("Q2");
        }
        else if(x < 0 && y < 0){
            System.out.println("Q3");
        }
        else if (x > 0 && y < 0){
            System.out.println("Q4");
        }
        else if(x == 0){
            System.out.println("Y-axis");
        }
        else if(y == 0){
            System.out.println("X-axis");
        }
        else{
            System.out.println("Origin");
        }
    }
}
