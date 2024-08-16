package Laboratorios.lab1;

public class lab1_v1 {
    public static void main(String[] args) {
        //Read the first index of the first word and compare to the same index of all the other words, if they are the same, add it to the prefix
        String[] words = new String[]{"BCCB", "CDDC", "ABAB", "ADCA", "CCCA", "DBBC", "DCBC", "BDDC", "BCBC", "BCDD", "BACB", "BADB", "DAAA", "ACAC", "ADCC", "BCAD", "BCAA", "CCAA", "BAAA", "ABAD", "DBAB", "DADA", "CCDA", "CDCA", "CADD", "DCBB", "CAAC", "ACCB", "BDDB", "CAAB", "ACAD", "ABCB", "BDBD", "CDDD", "CDAD", "ADDD", "CABD", "DDAB", "BAAD", "BBCA", "ACAB", "BABC", "ABBD", "ADDA", "BDDD", "BBBC", "DDDB", "BCCD", "CBDD", "ABAD"};
        String prefix = "";
        boolean equal = true;

        for (int index = 0; index < words[0].length(); index++) {  
            for (int i = 1; i < words.length; i++) {
                if (words[0].charAt(index) != words[i].charAt(index)) {
                    equal = false;
                    break;
                }
            }

            if (equal) {
                prefix += words[0].charAt(index);
            }
        }
        System.out.println(prefix);
    }
}
