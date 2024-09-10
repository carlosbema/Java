package exercises.composition.order.entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private int quantity;
    private Double price;
    private Product product;

    public OrderItem(Product product, int quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal(Product product, int quantity, Double price){
        return price * quantity;
    }
    @Override
    public String toString() {
        return "Order Items: " +
                "\nProducts=" + product +
                ", Quantity=" + quantity +
                ", Subtotal: " + subTotal(this.product, this.quantity, this.price);
    }
}
