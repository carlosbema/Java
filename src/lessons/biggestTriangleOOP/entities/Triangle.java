package lessons.biggestTriangleOOP.entities;

public class Triangle {

    public double a, b, c; // atributos

    public double area(){ //método
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }    
}
