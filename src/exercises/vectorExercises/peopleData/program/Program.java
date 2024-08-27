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
        double womanSum = 0;
        double womanAvg;
        int womanCount = 0;
        int manCount = 0;

        for (int i = 0; i < people.length; i++) {
            System.out.println((i + 1) + "th person data:");
            System.out.println("Height: ");
            double height = sc.nextDouble();
            System.out.println("Gender: ");
            char gender = sc.next().toUpperCase().charAt(0);
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

            if (people[i].getGender() == 'F') {
                womanSum += people[i].getHeight();
                womanCount++;
            }
            else if (people[i].getGender() == 'M') {
                manCount++;
            }
        }
        womanAvg = womanSum / womanCount;
        System.out.printf("Lowest: %.2f%n", lowestPerson);
        System.out.printf("Higher: %.2f%n", higherPerson);
        System.out.printf("Women average: %.2f%n", womanAvg);
        System.out.println("Men: " + manCount);

        sc.close();
    }
}
