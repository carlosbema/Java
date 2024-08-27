package collegeOldStuff;

import java.util.Scanner;
import java.lang.Math;

public class caixaDagua{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double raio = sc.nextDouble();
        double altura = sc.nextDouble();

        double volume = Math.PI * (raio * raio) * altura;
        System.out.printf("%.2f", volume);

        sc.close();
    }
}