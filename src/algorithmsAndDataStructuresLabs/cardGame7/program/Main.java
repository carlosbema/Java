package algorithmsAndDataStructuresLabs.cardGame7.program;

import algorithmsAndDataStructuresLabs.cardGame7.entities.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/C://Users//Vini//Java//src//partidas.txt/"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> cardNames = Arrays.asList(line.split(" "));
                Game game = new Game(cardNames);
                String result = game.playGame();
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
