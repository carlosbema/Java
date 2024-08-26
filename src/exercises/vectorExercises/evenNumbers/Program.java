package exercises.vectorExercises.evenNumbers;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale .setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the number of numbers: ");
        int quantity = sc.nextInt();
        int[] numbers = new int[quantity];
        String evenNumbers = "";

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Type the " + (i + 1) + "th number: ");
            numbers[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                count++;
                evenNumbers += numbers[i] + " ";
            }
        }

        System.out.println("Even numbers: \n" + evenNumbers);
        System.out.println("Quantity of even numbers: " + count);
        sc.close();
    }
}
