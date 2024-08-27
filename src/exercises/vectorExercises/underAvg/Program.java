package exercises.vectorExercises.underAvg;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("How many elements will the vector have?");
        int quantity = sc.nextInt();
        double[] vect = new double[quantity];
        double vectElementsSum = 0;
        double vectElementsAvg = 0;
        ArrayList<Double> underAvg = new ArrayList<>();

        for (int i = 0; i < quantity; i++){
            System.out.println("Type a number: ");
            vect[i] = sc.nextDouble();
            vectElementsSum += vect[i];
        }

        vectElementsAvg = vectElementsSum / quantity;
        System.out.println("Vector average: " + vectElementsAvg);

        for (int i = 0; i < quantity; i++){
            if (vect[i] < vectElementsAvg){
                underAvg.add(vect[i]);
            }
        }

        System.out.println("Elements under average: ");
        System.out.println(underAvg);
        sc.close();
    }
}
