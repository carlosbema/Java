package lessons;

import java.util.Scanner;

public class switch_case {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite um dia da semana: ");
        int x = sc.nextInt();
        String dia;
        switch (x) {
            case 1:
                dia = "Domingo";
                break;
            case 2:
                dia = "Segunda";
                break;
            case 3:
                dia = "Terça";
                break;
            case 4: 
                dia = "Quarta";
                break;
            case 5:
                dia = "Quinta";
                break;
            case 6: 
                dia = "Sexta";
                break;
            case 7:
                dia = "Sabado";
                break;
            default:
                dia = "Dia invalido";
                break;
        }
        System.out.println(dia);
    }
}
