package lessons;

import java.util.Locale;

public class teste {
    public static void main(String[] args) {
        System.out.print("Hello World!"); //print não quebra linha
        System.out.println("Hello World!"); //println quebra linha

        int y = 32;
        System.out.println(y);

        double x = 3.23423;
        System.out.printf("%.2f%n", x); //printf para floats, %.2f para 2 casas decimais
        Locale.setDefault(Locale.US); //Locale para mudar a vígula para ponto
        System.out.printf("%.4f%n", x); // %.4f para 4 casas decimais

        System.out.printf("Resultado: " + "%.2f" + " metros\n", x);

        String nome = "Carlos";
        int idade = 24;
        double renda = 4000.0;
        System.out.printf("%s tem %d anos e ganha R$ %.2f", nome, idade, renda);
    }
}
