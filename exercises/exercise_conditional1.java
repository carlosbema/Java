package exercises;

import java.util.Scanner;

public class exercise_conditional1 {
    public static void main(String[] args) {
        //Read a number and indicate if it is positive or negative
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a number: ");
        int x = sc.nextInt();
        if (x >= 0){
            System.out.println("Positive");
        }
        else{
            System.out.println("Negative");
        }
    }
}
