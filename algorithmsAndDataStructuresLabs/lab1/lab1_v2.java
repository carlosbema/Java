package Laboratorios.lab1;

import java.util.Arrays;

public class lab1_v2 {
    public static void main(String[] args) {
        String[] words = new String[]{"BCCB", "CDDC", "ABAB", "ADCA", "CCCA", "DBBC", "DCBC", "BDDC", "BCBC", "BCDD", "BACB", "BADB", "DAAA", "ACAC", "ADCC", "BCAD", "BCAA", "CCAA", "BAAA", "ABAD", "DBAB", "DADA", "CCDA", "CDCA", "CADD", "DCBB", "CAAC", "ACCB", "BDDB", "CAAB", "ACAD", "ABCB", "BDBD", "CDDD", "CDAD", "ADDD", "CABD", "DDAB", "BAAD", "BBCA", "ACAB", "BABC", "ABBD", "ADDA", "BDDD", "BBBC", "DDDB", "BCCD", "CBDD", "ABAD"};
        Arrays.sort(words);
        String prefix = "";
        for (int i = 0; i < words[0].length(); i++) {
            if (words[0].charAt(i) == words[words.length - 1].charAt(i)) {
                prefix += words[0].charAt(i);
            }
            else{
                break;
            }
        } 
        System.out.println(prefix);
    }
}
