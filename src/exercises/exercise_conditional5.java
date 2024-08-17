package exercises;

import java.util.Scanner;

public class exercise_conditional5 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the item code: ");        
        int codeItem = sc.nextInt();

        System.out.println("Type the quantity: ");
        int quantity = sc.nextInt();

        if(codeItem == 1){
            System.out.println("Total: U$ " + String.format("%.2f", 4.00 * quantity));
        } 
        else if(codeItem == 2){
            System.out.println("Total: U$ " + String.format("%.2f", 4.50 * quantity));
        } 
        else if(codeItem == 3){
            System.out.println("Total: U$ " + String.format("%.2f", 5.00 * quantity));
        } 
        else if(codeItem == 4){
            System.out.println("Total: U$ " + String.format("%.2f", 2.00 * quantity));
        } 
        else if(codeItem == 5){
            System.out.println("Total: U$ " + String.format("%.2f", 1.50 * quantity));
        } 
        else {
        System.out.println("Invalid item code");
        }
    }
}
