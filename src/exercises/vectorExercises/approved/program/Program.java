package exercises.vectorExercises.approved.program;

import java.util.Locale;
import java.util.Scanner;

import exercises.vectorExercises.approved.entities.Student;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the number of students: ");
        int quantity = sc.nextInt();
        
        Student[] students = new Student[quantity];
        for (int i = 0; i < students.length; i++) {
            System.out.println("Type the name of the " + (i + 1) + "th student: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Type the grade 1 of the " + (i + 1) + "th student: ");
            double grade1 = sc.nextDouble();
            System.out.println("Type the grade 2 of the " + (i + 1) + "th student: ");
            double grade2 = sc.nextDouble();
            students[i] = new Student(name, grade1, grade2);
        }

        System.out.println("Approved students: ");
        for (Student student : students) {
            if (student.approved()) {
                System.out.println(student.getName());
            }
        }
        sc.close();
    }
}
