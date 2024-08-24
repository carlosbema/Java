package lessons.vectors.productVectors.entities;
public class Product {
    private String name; //private -> acesso apenas dentro da classe
    private double price;
    private int quantity;

    public Product() { // é possível criar um construtor padrão
    }

    public Product(String name, double price, int quantity) { // contrutor
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price) { // sobrecarga
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }

    public double totalValueInStock() {
        return price * quantity;
    }

    public void addProducts(int quantity) {
        this.quantity += quantity;
    }

    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }

    public String toString() {
        return name
            + ", $ "
            + String.format("%.2f", price)
            + ", "
            + quantity
            + " units, Total: $ "
            + String.format("%.2f", totalValueInStock());
    }
}

