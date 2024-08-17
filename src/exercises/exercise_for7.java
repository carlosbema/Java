package exercises;

import java.util.Scanner;
public class exercise_for7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type a number: ");
        int value = sc.nextInt();
        for (int i = 1; i <= value; i++){
            int square = i * i;
            int cube = i * i * i;
            System.out.println(i + " " + square + " " + cube);
        }sc.close();
    }
}
