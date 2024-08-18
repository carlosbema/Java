package exercises.OOP.studentGrades.program;

import java.util.Locale;
import java.util.Scanner;

import exercises.OOP.studentGrades.entities.Student;

public class studentGrades {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();
        System.out.println("Name: ");
        student.name = sc.nextLine();
        System.out.println("Grade 1: ");
        student.grade1 = sc.nextDouble();
        System.out.println("Grade 2: ");
        student.grade2 = sc.nextDouble();
        System.out.println("Grade 3: ");
        student.grade3 = sc.nextDouble();

        System.out.println(student);
        sc.close();
    }
}
