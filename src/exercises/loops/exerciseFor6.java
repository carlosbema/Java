package exercises.loops;

import java.util.Scanner;

public class exerciseFor6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a number: ");
        int value = sc.nextInt();
        for (int i = 1; i < value; i++){
            if (value % i == 0){
                System.out.println(i);
            }
        }
        sc.close();
    }
}
