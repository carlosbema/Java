package collegeOldStuff;

import java.util.Scanner;

public class areasDeFiguras {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] escolha = new String[3];
        escolha = sc.nextLine().split(";");

        if(escolha[0].equals("Q")){
            double lado = Integer.parseInt(escolha[1]);
            double areaQuadrado = areaQuadrado(lado);
            System.out.println(areaQuadrado);
        }
        else if(escolha[0].equals("C")){
            double raio = sc.nextDouble();
            double areaC = areaCirculo(raio);
            System.out.println(areaC);
        }
        else if(escolha[0].equals("R")){
            double baseR = sc.nextDouble();
            double alturaR = sc.nextDouble();
            double areaR = areaRetangulo(baseR, alturaR);
            System.out.println(areaR);
        }
        else if(escolha[0].equals("T")){
            double lado1 = sc.nextDouble();
            double lado2 = sc.nextDouble();
            double lado3 = sc.nextDouble();
            double areaT = areaTriangulo(lado1, lado2, lado3);
            System.out.println(areaT);
        }
        else{
            System.out.println("Opção inválida!");
        }
        sc.close();
    }
    public static double areaQuadrado(double lado) {
        return lado * lado;
    }
    public static double areaCirculo(double raio) {
        return Math.PI * raio * raio;
    }
    public static double areaRetangulo(double base, double altura) {
        return base * altura;
    }
    public static double areaTriangulo(double lado1, double lado2, double lado3) {
        double valorS = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(valorS*(valorS-lado1)*(valorS-lado2)*(valorS-lado3));
    }
   
}

