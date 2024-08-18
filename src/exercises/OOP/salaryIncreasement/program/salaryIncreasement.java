package exercises.OOP.salaryIncreasement.program;

import java.util.Locale;
import java.util.Scanner;

import exercises.OOP.salaryIncreasement.entities.Employee;

public class salaryIncreasement {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee employee = new Employee();
        System.out.println("Name: ");
        employee.name = sc.nextLine();
        System.out.println("Gross salary: ");
        employee.grossSalary = sc.nextDouble();
        System.out.println("Tax: ");
        employee.tax = sc.nextDouble();

        System.out.println("Employee: " + employee);

        System.out.println("Which percentage to increase salary? ");
        double percentage = sc.nextDouble();
        employee.IncreaseSalary(percentage);

        System.out.println("Updated data: " + employee);

        sc.close();
    }
}
