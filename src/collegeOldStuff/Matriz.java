import java.util.Scanner;

public class Matriz {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String[][] matrizStr = new String[5][5];
        int[][] matriz = new int[5][5];
        int i;
        for (i = 0; i < 5; i++) {
                matrizStr[i] = sc.nextLine().split(";");
        }
        for (i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = Integer.parseInt(matrizStr[i][j]);
            }
        }

        int somaLinha4 = 0;
        for (i = 0; i < 5; i++) {
            somaLinha4 += matriz[3][i];
        }
        System.out.println(somaLinha4);

        int somaColuna2 = 0;
        for ( i = 0; i < 5; i++) {
            somaColuna2 += matriz[i][1];
        }
        System.out.println(somaColuna2);

        int somaDiagonalPrincipal = 0;
        for ( i = 0; i < 5; i++) {
            somaDiagonalPrincipal += matriz[i][i];
        }
        System.out.println(somaDiagonalPrincipal);

        int somaDiagonalSecundaria = 0;
        for ( i = 0; i < 5; i++) {
            somaDiagonalSecundaria += matriz[i][4 - i];
        }
        System.out.println(somaDiagonalSecundaria);

        int somaTotal = 0;
        for ( i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                somaTotal += matriz[i][j];
            }
        }
        System.out.println(somaTotal);
    }
}

