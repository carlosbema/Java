package exercises;

import java.util.Scanner;

public class exerciseFor5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a number: ");
        int value = sc.nextInt();
        switch (value) {
            case 0:
                value = 1;        
            default:
                break;
        }
        for (int i = value - 1; i > 0; i--){
            value *= i;
        }
        System.out.println(value);
        sc.close();
    }
}
