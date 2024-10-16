package src.algorithmsAndDataStructuresLabs.exercises.enferrujados.entities;

import java.util.*;

public class Game {
    private Stack<Card> drawPile;
    private Deque<Card> tableCards;
    private Player player1;
    private Player player2;

    public Game(List<Card> initialDeck) {
        drawPile = new Stack<>();
        Collections.reverse(initialDeck);
        drawPile.addAll(initialDeck);

        tableCards = new ArrayDeque<>();

        player1 = new Player1("Jogador 1");
        player2 = new Player2("Jogador 2");

        for (int i = 0; i < 4; i++) {
            player1.drawCard(drawPile);
        }
        for (int i = 0; i < 4; i++) {
            player2.drawCard(drawPile);
        }
        for (int i = 0; i < 4; i++) {
            if (!drawPile.isEmpty()) {
                tableCards.addLast(drawPile.pop());
            }
        }
    }

    public void play() {
        Player currentPlayer = player1;
        while (true) {
            TurnResult result = currentPlayer.playTurn(tableCards, drawPile);
            currentPlayer.drawCard(drawPile);

            if (!drawPile.isEmpty()) {
                Card card = drawPile.pop();
                if (result.collected) {
                    if (result.collectedFromLeft) {
                        tableCards.addFirst(card);
                    } else {
                        tableCards.addLast(card);
                    }
                } else if (result.placedCard) {
                    if (result.placedOnLeft) {
                        tableCards.addLast(card);
                    } else {
                        tableCards.addFirst(card);
                    }
                } else {
                    tableCards.addLast(card);
                }
            }

            if (drawPile.isEmpty()) {
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        int player1Score = player1.getCollectedCardsCount();
        int player2Score = player2.getCollectedCardsCount();

        if (player1Score > player2Score) {
            System.out.println(player1Score + " " + player2Score + " Jogador 1");
        } else if (player2Score > player1Score) {
            System.out.println(player1Score + " " + player2Score + " Jogador 2");
        } else {
            System.out.println(player1Score + " " + player2Score + " Empate");
        }
    }
}
