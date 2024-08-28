package lessons.matrix;

import java.util.Locale;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int negativeCount = 0;

        System.out.println("Enter the size of the matrix: ");
        int size = sc.nextInt();
        
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.println("Enter a number for position [" + i + "][" + j + "]");
                matrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.print("Main diagonal: ");
        for (int i = 0; i < matrix.length; i++){
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();
        System.out.print("Negative numbers count: ");
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j] < 0){
                    negativeCount++;
                }
            }
        }
        System.out.print(negativeCount);
        sc.close();
    }
}
