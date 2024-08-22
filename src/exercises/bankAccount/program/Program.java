package exercises.bankAccount.program;

import java.util.Locale;
import java.util.Scanner;

import exercises.bankAccount.entities.Client;

public class Program {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account number: ");
        int accNumber = sc.nextInt();
        System.out.println("Enter account holder: ");
        sc.nextLine();
        String accHolder = sc.nextLine();
        System.out.println("Is there an initial deposit (y/n)? ");
        String initialAnswer = sc.nextLine();

        Client client = new Client(accNumber, accHolder);

        if (initialAnswer.contains("y")) {
            System.out.println("Enter initial deposit: ");
            Double balance = sc.nextDouble();
            client.deposit(balance);
        }

        System.out.println("Account data: \n" + client);

        System.out.println("Type D for a deposit, W for a Withdrawal, or Q to quit: ");
        char option = sc.next().charAt(0);

        while (option != 'Q') {
            if (option == 'D') {
                System.out.println("Enter amount: ");
                Double value = sc.nextDouble();
                client.deposit(value);
            }
            else if (option == 'W') {
                System.out.println("Enter amount: ");
                Double value = sc.nextDouble();
                client.withdraw(value);
            }
            System.out.println("Account data: \n" + client);
            System.out.println("Type D for a deposit, W for a Withdrawal, or Q to quit: ");
            option = sc.next().charAt(0);
        }
        sc.close();
    }
}
