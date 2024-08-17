package lessons.loops;

import java.util.Scanner;

public class doWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        do {
            System.out.println("Type the Celsius value: ");
            double c = sc.nextDouble();
            double f = (9.0 / 5) * c + 32;
            System.out.println("Fahrenheit = " + f);
            System.out.println("Do you want to continue?");
            answer = sc.next();
        } while (!answer.equals("no"));
        sc.close();
    }
}
