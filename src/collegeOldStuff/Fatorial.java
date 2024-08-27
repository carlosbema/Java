package collegeOldStuff;

import java.math.BigInteger;
import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        BigInteger resultado = fatorial(n);
        System.out.println(resultado);
    }

    public static BigInteger fatorial(int n) {
        BigInteger fatorial = BigInteger.ONE; // 1 é o fatorial de 0 ou 1
        for (int i = 2; i <= n; i++) {
            fatorial = fatorial.multiply(BigInteger.valueOf(i));
        }
        return fatorial;
    }
}