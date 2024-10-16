package src.lessons.heritage.application;

import src.lessons.heritage.entities.Account;
import src.lessons.heritage.entities.BusinessAccount;
import src.lessons.heritage.entities.SavingsAccount;

public class Program {
    public static void main(String[] args) {
        Account acc = new Account(1, "Carlos", 1000.0);
        BusinessAccount bacc = new BusinessAccount(2, "Vinicius", 500.0, 100.0);

        //UPCASTING
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(3, "Diego", 500.0, 100.0);
        Account acc3 = new SavingsAccount(4, "Pedro", 500.0, 100.0);

        //DOWNCASTING

        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(500.0);

        //BusinessAccount acc5 = (BusinessAccount) acc3;

        if(acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan");
        }

        if(acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update");
        }
    }
}
