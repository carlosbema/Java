package exercises.vectorExercises.evenAvg;

import java.util.Locale;
import java.util.Scanner;
//Read N numbers, then show the even numbers avg
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements the vector will have?");
        int quantity = sc.nextInt();
        int[] vect = new int[quantity];
        int evenSum = 0;
        int evenCount = 0;
        double evenAvg = 0;

        for (int i = 0; i < vect.length; i++){
            System.out.println("Type a number: ");
            vect[i] = sc.nextInt();
            if (vect[i] % 2 == 0){
                evenSum += vect[i];
                evenCount ++;
            }
        }
        if (evenCount > 0){
            evenAvg = evenSum / evenCount;
            System.out.println("Even average: " + evenAvg);
        }
        else{
            System.out.println("No even numbers");
        }
        sc.close();
    }
}
