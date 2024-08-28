package exercises.lists.program;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import exercises.lists.entities.Employee;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many employees will be registered?");
        int quantity = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.println("Id: ");
            int id = sc.nextInt();
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Salary: ");
            double salary = sc.nextDouble();
            employees.add(new Employee(id, name, salary));
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.println("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println("List of employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        sc.close();
    }
}
