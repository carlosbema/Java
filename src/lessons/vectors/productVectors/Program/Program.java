package lessons.vectors.productVectors.Program;

import java.util.Locale;
import java.util.Scanner;
import lessons.vectors.productVectors.entities.Product;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of products: ");
        int n = sc.nextInt();
        Product[] vect = new Product[n];

        for (int i = 0; i < vect.length; i++) {
            sc.nextLine();
            System.out.println("Type product name: ");
            String name = sc.nextLine();
            System.out.println("Type product price: ");
            double price = sc.nextDouble();
            vect[i] = new Product(name, price);
        }

        double sum = 0.0;
        for (int i = 0; i < vect.length; i++) {
            sum += vect[i].getPrice();
        }
        double avg = sum / vect.length;
        System.out.println("Average price: " + String.format("%.2f", avg));
        sc.close();
    }
}
