package exercises.composition.order2.entities;

import exercises.composition.order.entities.OrderItem;

import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private String status;
    private Client client;
    private List<OrderItem> orderItems;

    public Order() {}

    public Order(Client client, Date moment, String status) {
        this.client = client;
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }
}
