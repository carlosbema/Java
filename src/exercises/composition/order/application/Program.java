package exercises.composition.order.application;

import exercises.composition.order.entities.Client;
import exercises.composition.order.entities.Order;
import exercises.composition.order.entities.OrderItem;
import exercises.composition.order.entities.Product;
import lessons.enumerator.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Dados cliente
        System.out.println("Enter client data: ");
        System.out.println("Name: " );
        String name = sc.nextLine();
        System.out.println("E-mail: ");
        String email = sc.next();
        System.out.println("Birth date: ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        //Dados pedido
        System.out.println("Enter order data: ");
        System.out.println("Order status: ");
        OrderStatus orderStatus =  OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), orderStatus, client);

        System.out.println("How many items to this order? ");
        int items = sc.nextInt();

        for(int i = 0; i < items; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.println("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem oi = new OrderItem(productQuantity, productPrice, product);

            order.addOrderItem(oi);
        }

        System.out.println();
        System.out.println(order);
        sc.close();
    }
}
