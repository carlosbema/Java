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
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        //Dados cliente
        System.out.println("Enter client data: ");
        System.out.println("Name: " );
        String name = sc.nextLine();
        System.out.println("E-mail: ");
        String email = sc.nextLine();
        System.out.println("Birth date: ");
        Date birthDate = sdf.parse(sc.nextLine());

        //Dados pedido
        System.out.println("Enter order data: ");
        System.out.println("Order status: ");
        OrderStatus orderStatus =  OrderStatus.valueOf(sc.nextLine());
        System.out.println("How many items to this order? ");
        int items = sc.nextInt();

        Order order = new Order(Instant.now(), orderStatus, new Client(name, email, birthDate));

        for(int i = 0; i < items; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.println("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int productQuantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(new Product(productName, productPrice), productQuantity, productPrice);
            order.addOrderItem(orderItem);
        }

        System.out.println(order + "\n" +
                order.getClient().toString() +
                "\nOrder items: ");
        System.out.println(order.getOrderItems());
        for (OrderItem o : order.getOrderItems()) {
            System.out.println(o.getProduct());
        }
    }
}
