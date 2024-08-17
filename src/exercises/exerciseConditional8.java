package exercises;

import java.util.Scanner;

public class exerciseConditional8 {
    public static void main(String[] args) {
        //read the salary and print how much the Brazilian government will steal from you
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Type the salary: ");
        double salary = sc.nextDouble();
        double tax = 0.0;

        if (salary <= 2000.00) {
            System.out.println("Free");
        }   
        else if (salary <= 3000.00) {
            double firstRange = salary - 2000.00;
            tax = firstRange * 0.08;
            System.out.println(tax);
        }
        else if (salary <= 4500.00) {
            double secondRange = salary - 3000.00;
            double firstRange = salary - secondRange - 2000.00;
            tax = (firstRange * 0.08) + (secondRange * 0.18);
            System.out.println(tax);
        }    
        else {
            double thirdRange = salary - 4500.00;
            double secondRange = salary - thirdRange - 3000.00;
            double firstRange = salary - secondRange - thirdRange - 2000.00;
            tax = (firstRange * 0.08) + (secondRange * 0.18) + (thirdRange * 0.28);
            System.out.println(tax);
        }
    }
}
