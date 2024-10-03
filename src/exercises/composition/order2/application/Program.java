package exercises.composition.order2.application;

import exercises.composition.order2.entities.Client;
import exercises.composition.order2.entities.Order;
import exercises.composition.order2.entities.OrderItem;
import exercises.composition.order2.entities.Product;
import exercises.composition.order2.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("E-mail: ");
        String email = sc.nextLine();
        System.out.println("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.println("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        System.out.println("How many items to this order?");
        int items = sc.nextInt();

        Order order = new Order(client, new Date(), status);

        for (int i = 0; i < items; i++) {
            System.out.println("Enter product data: ");
            System.out.println("Name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Price: ");
            double price = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, price);

            OrderItem orderItem = new OrderItem(quantity, price, product);

            order.addOrderItem(orderItem);
        }
        System.out.println(order.toString());
    }
}
