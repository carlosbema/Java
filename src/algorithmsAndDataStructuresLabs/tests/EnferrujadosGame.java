package algorithmsAndDataStructuresLabs.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class EnferrujadosGame {
    public static void main(String[] args) {
        String fileName = "C:/Users/Vini/Java/src/algorithmsAndDataStructuresLabs/tests/cartas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Processa cada monte de cartas (cada linha corresponde a um monte)
            while ((line = br.readLine()) != null) {
                List<Card> deckList = new ArrayList<>();
                String[] cardNames = line.trim().split("\\s+");
                for (String cardName : cardNames) {
                    deckList.add(new Card(cardName));
                }
                Game game = new Game(deckList);
                String result = game.play();
                System.out.println(result);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo 'cartas.txt'. Verifique se o arquivo existe e está no diretório correto.");
            e.printStackTrace();
        }
    }
}

