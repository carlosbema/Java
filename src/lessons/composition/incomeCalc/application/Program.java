package src.lessons.composition.incomeCalc.application;

import src.lessons.composition.incomeCalc.entities.Department;
import src.lessons.composition.incomeCalc.entities.HourContract;
import src.lessons.composition.incomeCalc.entities.Worker;
import lessons.composition.incomeCalc.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        System.out.println("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = sc.nextLine();
        System.out.println("Level: ");
        String workerLevel = sc.nextLine();
        System.out.println("Base salary: ");
        Double workerBaseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));
        System.out.println(worker);

        System.out.println("How many contracts?");
        int qntContracts = sc.nextInt();

        for (int i = 0; i < qntContracts; i++) {
            System.out.println("Enter " + (i + 1) + "'s contract data: ");
            System.out.println("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.println("Duration: ");
            Integer duration = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, duration);
            worker.addContract(contract);
        }

        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3, 7));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + month + "/" + year + ": " + String.format("%.2f", worker.income(year, month)));
        sc.close();
    }
}
