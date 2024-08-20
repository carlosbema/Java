package lessons.constructors.stockWithConstructor.program;
import java.util.Scanner;
import java.util.Locale;

import lessons.constructors.stockWithConstructor.entities.Product;
public class productStock {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity in stock: ");
        int quantity = sc.nextInt();

        Product television = new Product(name, price, quantity);

        System.out.println("Product data" + television);

        System.out.println("Enter the number of products to be added in stock: ");
        quantity = sc.nextInt();
        television.addProducts(quantity);
        System.out.println("Updated data: " + television);

        System.out.println("Enter the number of products to be removed from stock: ");
        quantity = sc.nextInt();
        television.removeProducts(quantity);
        System.out.println("Updated data: " + television);

        sc.close();
    }
}