package lessons.static_.util;

public class calculator {
    public static final double PI = 3.14159; //constants should be written in uppercase

    public static double circumference(double radius) {
        double c = 2 * PI * radius;
        return c;
    }

    public static double volume(double radius) {
        double v = 4.0 / 3.0 * PI * Math.pow(radius, 3.0);
        return v;
    }
}
