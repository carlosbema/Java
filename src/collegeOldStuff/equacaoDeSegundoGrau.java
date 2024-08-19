import java.util.Scanner;

public class equacaoDeSegundoGrau {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if(a ==0){
            System.out.println("Erro!");
        }
        else{
            double delta = b * b - 4 * a  * c;
        

        if(delta < 0){
            System.out.println("Sem raiz real");
        }
        else if (delta == 0){
            double x1 = -b / (2 * a);
            System.out.println(x1);
        }
        else{
            double x1 = (-b +  Math.sqrt(delta)) / (2 * a);
            double x2 = (-b -  Math.sqrt(delta)) / (2 * a);
            System.out.printf("%.2f;%.2f", x1, x2);
            }
        }
        sc.close();
    }
} 
    

