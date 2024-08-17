package lessons.loops;

public class while1 {
    public static void main(String[] args) {
        int x = 5;
        int sum = 0;
        while (x > 0) {
            System.out.println(x);
            x = x - 1;
            sum += x;
        }
        System.out.println(sum);
    }
}
