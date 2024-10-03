package exercises.composition.order2.entities;

public class OrderItem {
    private int quantity;
    private double price;
    private Product product;

    public OrderItem(){}

    public OrderItem(int quantity, double price, Product product) {}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void addProduct(Product product) {
        this.product = product;
    }

    public Double subTotal(int quantity, double price) {
        return quantity * price;
    }

    @Override
    public String toString() {
        return "OrderItems: " +
                "quantity=" + quantity +
                ", price=" + product.getPrice() +
                ", product=" + product.getName() +
                '}';
    }
}
