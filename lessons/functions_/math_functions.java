package lessons.functions_;
import java.util.Scanner;

public class math_functions {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 3 valores: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        double A = Math.sqrt(x); // raiz quadrada
        double B = Math.pow(x, y); // x elevado a y
        int C = Math.abs(z); // valor absoluto

        System.out.println(x + " elevado ao quadrado é " + A);
        System.out.println(x + " elevado a " + y + " é " + B);
        System.out.println("Valor absoluto de " + x + " é " + C);
    }

}
