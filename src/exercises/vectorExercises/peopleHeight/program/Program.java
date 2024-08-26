package exercises.vectorExercises.peopleHeight.program;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

import exercises.vectorExercises.peopleHeight.entities.Person;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the number of people: ");
        int quantity = sc.nextInt();
        double heightSum = 0;
        double heightAvg = 0;
        int underSixteen = 0;
        ArrayList<String> underSixteenList = new ArrayList<>();

        Person[] people = new Person[quantity];
        for (int i = 0; i < quantity; i++) {
            System.out.println((i + 1) + "th person data: ");
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Age: ");
            int age = sc.nextInt();
            System.out.println("Height: ");
            double height = sc.nextDouble();
            people[i] = new Person(name, age, height);
            heightSum += height;
            if (age < 16){
                underSixteen++;
                underSixteenList.add(name);
            }
        }
        heightAvg = heightSum / quantity;
        System.out.printf("Height Average: %.2f%n", heightAvg);
        System.out.println("People under 16: " + (underSixteen * 100 / 5) + "%");
        for (int i = 0; i < underSixteenList.size(); i++) {
            System.out.println(underSixteenList.get(i));
        }
        sc.close();
    }
}
