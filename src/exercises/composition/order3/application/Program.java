package exercises.composition.order3.application;

import exercises.composition.order3.entities.Client;
import exercises.composition.order3.entities.Order;
import exercises.composition.order3.entities.OrderItem;
import exercises.composition.order3.entities.Product;
import exercises.composition.order3.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        SimpleDateFormat sdfMoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
        Locale.setDefault(Locale.US);

        System.out.println("Enter client data: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdfDate.parse(sc.nextLine());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.println("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        System.out.println("How many items to this order?");
        int items = sc.nextInt();

        Order order = new Order(status, new Date(), client);

        for (int i = 1; i <= items; i++) {
            System.out.println("Enter item #" + i + " data: ");
            System.out.println("Product product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Product product price: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println("Order Summary: ");
        System.out.println("Order moment: " + sdfMoment.format(order.getMoment()));
        System.out.println("Order status: " + order.getStatus());
        System.out.println(client);
        System.out.println("Order items:");
        Double total = 0.0;
        for (OrderItem orderItem : order.getItems()) {
            System.out.println(orderItem.toString());
            total += orderItem.subTotal();
        }
        System.out.println("Total price: $" + total);
    }
}
