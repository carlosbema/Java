package lessons.composition.order.entities;

import lessons.composition.incomeCalc.entities.HourContract;
import lessons.enumerator.enums.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Instant moment;
    private OrderStatus status;

    private Client client = new Client();
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {

    }

    ;

    public Order(Instant moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeOrderItem(OrderItem item) {
        orderItems.remove(item);
    }

    @Override
    public String toString() {
        return "ORDER SUMMARY: " +
                "\nOrder Moment: " + moment +
                "\nOrder Status: " + status +
                "\n" + client.toString() +
                "\n" + orderItems.toString();
    }
}

