package exercises.conditionals;

import java.util.Scanner;

public class exerciseConditional4 {
    public static void main(String[] args) {
        //Read 2 hours and print the duration of the game
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the start hour: ");
        int startHour = sc.nextInt();

        System.out.println("Type the final hour: ");
        int finalHour = sc.nextInt();
        int duration;

        if(finalHour > startHour){
            duration = finalHour - startHour;
            System.out.println("The game lasted " + duration + " hours");
        }
        else{
            duration = 24 - startHour + finalHour;
            System.out.println("The game lasted " + (duration) + " hours");
        }
    }
}
