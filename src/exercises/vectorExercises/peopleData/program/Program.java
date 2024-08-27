package exercises.vectorExercises.peopleData.program;

import java.util.Locale;
import java.util.Scanner;

import exercises.vectorExercises.peopleData.entities.Person;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many people will be registered?");
        int quantity = sc.nextInt();
        Person[] people = new Person[quantity];
        double higherPerson;
        double lowestPerson;

        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + "th person data:");
            System.out.println("Height: ");
            double height = sc.nextDouble();
            System.out.println("Gender: ");
            char gender = sc.next().charAt(0);
            people[i] = new Person(height, gender);
        }
        higherPerson = people[0].getHeight();
        lowestPerson = people[0].getHeight();
        for (int i = 0; i < people.length; i++) {
            if (people[i].getHeight() > higherPerson) {
                higherPerson = people[i].getHeight();
            }
            else if (people[i].getHeight() < lowestPerson) {
                lowestPerson = people[i].getHeight();
            }
        }
        System.out.println("Higher: " + higherPerson);
        System.out.println("Lowest: " + lowestPerson);
        sc.close();
    }
}
