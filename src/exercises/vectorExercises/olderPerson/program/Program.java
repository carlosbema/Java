package exercises.vectorExercises.olderPerson.program;

import java.util.Locale;
import java.util.Scanner;
import exercises.vectorExercises.olderPerson.entities.Person;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("How many people will be registered?");
        int quantity = sc.nextInt();
        Person[] people = new Person[quantity];
        String older;

        for (int i = 0; i < quantity; i++) {
            System.out.println((i + 1) + "th person data:");
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            people[i] = new Person(name, age);
        }

        older = people[0].getName();

        for (int i = 1; i < people.length; i++) {
            if (people[i].getAge() > people[i-1].getAge()) {        
                older = people[i].getName();
            }
            
        }
        System.out.println("Older person: " + older);
        sc.close();
    }
}
