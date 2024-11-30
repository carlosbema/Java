package src.algorithmsAndDataStructuresLabs.exercises.enferrujados.Program;

import src.algorithmsAndDataStructuresLabs.exercises.enferrujados.entities.Card;
import src.algorithmsAndDataStructuresLabs.exercises.enferrujados.entities.Game;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/partidas.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] cardNames = line.trim().split("\\s+");
                List<Card> deck = new ArrayList<>();
                for (String name : cardNames) {
                    deck.add(new Card(name));
                }
                Game game = new Game(deck);
                game.play();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
