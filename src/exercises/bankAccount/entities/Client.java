package exercises.bankAccount.entities;

public class Client {

    private int accNumber;
    private String accHolder;
    private double balance;

    public Client () {}
    public Client (int accNumber, String accHolder, double balance) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.balance = balance;
    }
    public Client (int accNumber, String accHolder) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
    }
    public int getAccNumber() {
        return accNumber;
    }
    public String getaccHolder() {
        return accHolder;
    }
    public void setaccHolder(String accHolder) {
        this.accHolder = accHolder;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double value) {
        balance += value;
    }
    public void withdraw(double value) {
        balance -= value + 5.00;
    }

    public String toString() {
        return "Account " + accNumber +
            ", Holder: " + accHolder +
            ", Balance: $" + balance; 
    }
}