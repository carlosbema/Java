package algorithmsAndDataStructuresLabs.cardGame5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String fileName = "/C://Users//Vini//Downloads//partidas (1).txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // For each line, create a deck and play a game
                Stack<Card> deck = new Stack<>(); // Using Stack to represent the deck
                String[] cardNames = line.split(" ");
                // The deck is a stack, so the first card in the array should be at the bottom of the stack
                // So we need to push the cards in reverse order
                for (int i = cardNames.length - 1; i >= 0; i--) {
                    deck.push(new Card(cardNames[i]));
                }

                Game game = new Game(deck);
                game.playGame();

                int player1Score = game.getPlayer1CollectedCardsCount();
                int player2Score = game.getPlayer2CollectedCardsCount();

                if (player1Score > player2Score) {
                    System.out.println(player1Score + " " + player2Score + " Jogador 1");
                } else if (player2Score > player1Score) {
                    System.out.println(player1Score + " " + player2Score + " Jogador 2");
                } else {
                    System.out.println(player1Score + " " + player2Score + " Empate");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
