package exercises.OOP.rectangleArea.program;
import java.util.Locale;
import java.util.Scanner;

import exercises.OOP.rectangleArea.entities.Rectangle;
public class rectangleArea {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();

        System.out.println("Enter rectangle width and height: ");
        rectangle.width = sc.nextDouble();
        rectangle.height = sc.nextDouble();
        System.out.println("Area: " + rectangle.Area());
        System.out.println("Perimeter: " + rectangle.Perimeter());
        System.out.println("Diagonal: " + rectangle.Diagonal());

        sc.close();
    }
}
