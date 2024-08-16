package lessons;

public class string_functions {
    public static void main(String[] args) {
        String name = "Carlos Vinicius";

        String nameLower = name.toLowerCase(); // converte para minuscula
        System.out.println(nameLower + " lower");

        String nameUpper = name.toUpperCase(); // converte para maiuscula
        System.out.println(nameUpper + " upper");

        String nameTrim = name.trim(); // remove espacos
        System.out.println(nameTrim + " trimmed");

        String nameSubString = name.substring(0, 5); // corta a string
        System.out.println(nameSubString + " substring");

        String nameReplace = name.replace("i", "x"); // substitui
        System.out.println(nameReplace);

        int i = name.indexOf("i"); // encontra o primeiro indice
        System.out.println(i);

        int j = name.lastIndexOf("i"); // encontra o ultimo indice
        System.out.println(j);
        
        String s = "potato apple lemon";

        String[] words = s.split(" "); // corta a string
        String word1 = words[0];
        String word2 = words[1];
        String word3 = words[2];
        System.out.println(word1);
        System.out.println(word2);
        System.out.println(word3);
    }
}
