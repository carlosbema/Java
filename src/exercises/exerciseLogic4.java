package exercises;

import java.util.Scanner;

public class exerciseLogic4 {
    public static void main(String[] args) {
        //Read the person number, worked hours and hourSalary and print the salary
        int personNumber, workedHours;
        double hourSalary;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the person number: ");
        personNumber = sc.nextInt();
        System.out.println("Type the worked hours: ");
        workedHours = sc.nextInt();
        System.out.println("Type the salary: ");
        hourSalary = sc.nextDouble();

        System.out.println("NUMBER = " + personNumber);
        System.out.println("SALARY = U$ " + String.format("%.2f", (workedHours * hourSalary)));
    }
}
