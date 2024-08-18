package exercises.generalBasics;
import java.util.Scanner;

public class exerciseLogic1 {
    public static void main(String[] args) {
        //Read 2 values and print their sum
        System.out.println("Type the 1st value: ");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        System.out.println("Type the 2nd value: ");
        int y = sc.nextInt();

        System.out.println("Sum = " + (x + y));
    }
}
