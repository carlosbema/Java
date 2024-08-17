package lessons.generalBasics;

public class casting {
    public static void main(String[] args) {
        int x = 5;
        double y = 2 * x;
        System.out.println(x);
        System.out.println(y); //o valor é convertido para double caso um dos valores envolvidos seja double

        double b, B, h;
        b = 6.0; //utilizar .0 mesmo que não tenha casas decimais
        B = 8.0;
        h = 5.0;

        double area = (b + B) / 2.0 * h;
        System.out.println(area);

        int a, c;
        double resultado;

        a = 5;
        c = 2;

        resultado = (double) a / c;
        System.out.println(resultado);
    }
}
