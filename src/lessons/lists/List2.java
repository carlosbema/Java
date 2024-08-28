package lessons.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class List2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Anna");
        list.add(2, "Marco");
        list.add("Anna");

        System.out.println("Size: " + list.size());

        list.remove("Anna"); // removes the first "Anna"
        list.remove(1); // removes the element at index 1
        list.removeIf(x -> x.charAt(0) == 'M'); // removes all elements that start with 'M'

        System.out.println("Index of Bob: " + list.indexOf("Bob"));
        for (String x : list) {
            System.out.println(x);
        }

        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); // stream is used to allow lambda expressions (x -> x.charAt(0) == 'A'), collect is used to collect the results in a list
        System.out.println("-----------------------------------");
        System.out.println("Starting with A: ");
        for (String x : result) {
            System.out.println(x);
        }

        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null); // stream is used to allow lambda expressions (x -> x.charAt(0) == 'A'), findFirst is used to find the first element that matches the condition, orElse is used to return null if no element is found
        System.out.println("-----------------------------------");
        System.out.println("First name starting with A: " + name);
    }
}



