package lessons.forEach;

public class ForEach {
    public static void main(String[] args) {
        String[] vect = new String[]{"Maria", "Bob", "Alex"};

        for (String obj : vect) { // each obj represents one element of the array
            System.out.println(obj);
        }
    }
}
