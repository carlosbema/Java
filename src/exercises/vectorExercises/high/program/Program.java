package exercises.vectorExercises.high.program;

import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

import exercises.vectorExercises.high.entities.Person;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many people will be registered?");
        int quantity = sc.nextInt();
        
        Person person;
        Vector<Person> peopleVect = new Vector<>();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Name: ");
            sc.nextLine();
        }

        sc.close();
    }
}
