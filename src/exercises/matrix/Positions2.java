package exercises.matrix;

import java.util.Locale;
import java.util.Scanner;
//mesmo programa de Position.java, só refiz pra fixar o conteúdo porque fiquei 1 dia fora
public class Positions2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o numero de linhas: ");
        int linhas = sc.nextInt();
        System.out.println("Digite o numero de colunas: ");
        int colunas = sc.nextInt();

        int[][] matrix = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                System.out.println("Digite o valor da posicao [" + i + "][" + j + "]");
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Digite o numero a ser procurado: ");
        int procurado = sc.nextInt();

        for (int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++){
                if (matrix[i][j] == procurado){
                    System.out.println("Position: [" + i + "][" + j + "]");
                    if (j - 1 >= 0){
                        System.out.println("Left: " + matrix[i][j - 1]);
                    }
                    if (i - 1 >= 0){
                        System.out.println("Up: " + matrix[i - 1][j]);
                    }
                    if (j + 1 <= linhas){
                        System.out.println("Right: " + matrix[i][j + 1]);
                    }
                    if (i + 1 <= colunas){
                        System.out.println("Down: " + matrix[i + 1][j]);
                    }
                }
            }
        }
        sc.close();
    }
}
