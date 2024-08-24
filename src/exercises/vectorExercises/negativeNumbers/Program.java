package exercises.vectorExercises.negativeNumbers;

import java.util.Locale;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int numberQuantity = 0;

        while (numberQuantity < 1 || numberQuantity > 10) {
            System.out.println("Enter the number of numbers: ");
            numberQuantity = sc.nextInt();
        }
        
        int[] numbers = new int[numberQuantity];
        for (int i = 0; i < numberQuantity; i++){
            System.out.println("Type the " + (i + 1) + "th number: ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("Números negativos: ");
        for (int i = 0; i < numberQuantity; i++){
            if (numbers[i] < 0){
                System.out.println(numbers[i]);
            }
        }
        sc.close();
    }
}