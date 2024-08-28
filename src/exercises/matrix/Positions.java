package exercises.matrix;

import java.util.Locale;
import java.util.Scanner;

public class Positions {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Type the position [" + i + "][" + j + "]");
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println();
        System.out.println("Type the number which will be located: ");
        int number = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == number) {
                    System.out.print("Position: [" + i + "][" + j + "], ");
                    if (j > 0) {
                        System.out.print("Left: " + matrix[i][j - 1] + ", ");
                    }
                    if (i > 0) {
                        System.out.print("Up: " + matrix[i - 1][j] + ", ");
                    }
                    if (j < columns - 1) {
                        System.out.print("Right: " + matrix[i][j + 1] + ", ");
                    }
                    if (i < rows - 1) {
                        System.out.println("Down: " + matrix[i + 1][j]);
                    }
                }
            }
        }

        sc.close();
    }
}

