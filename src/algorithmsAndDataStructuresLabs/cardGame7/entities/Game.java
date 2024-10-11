package algorithmsAndDataStructuresLabs.cardGame7.entities;

import java.util.*;

public class Game {
    private Stack<Card> deck;
    private Deque<Card> tableCards;
    private Player player1;
    private Player player2;

    public Game(List<String> cardNames) {
        deck = new Stack<>();
        for (String name : cardNames) {
            deck.push(new Card(name));
        }
        Collections.shuffle(deck);

        tableCards = new ArrayDeque<>();
        player1 = new Player1();
        player2 = new Player2();

        initializeGame();
    }

    private void initializeGame() {
        for (int i = 0; i < 4; i++) {
            player1.addCardToHand(deck.pop());
            player2.addCardToHand(deck.pop());
            tableCards.add(deck.pop());
        }
    }

    public String playGame() {
        Player currentPlayer = player1;

        while (!deck.isEmpty()) {
            Move move = currentPlayer.makeMove(tableCards);

            if (move.isCollecting()) {
                List<Card> collectedCards = new ArrayList<>();
                if (move.isRight()) {
                    while (!tableCards.isEmpty() && tableCards.peekLast().equals(move.getCard())) {
                        collectedCards.add(tableCards.removeLast());
                    }
                } else {
                    while (!tableCards.isEmpty() && tableCards.peekFirst().equals(move.getCard())) {
                        collectedCards.add(tableCards.removeFirst());
                    }
                }
                collectedCards.add(move.getCard());
                currentPlayer.collectCards(collectedCards);
            } else {
                if (move.isRight()) {
                    tableCards.addLast(move.getCard());
                } else {
                    tableCards.addFirst(move.getCard());
                }
            }

            currentPlayer.addCardToHand(deck.pop());

            if (!deck.isEmpty()) {
                Card newTableCard = deck.pop();
                if (move.isCollecting()) {
                    if (move.isRight()) {
                        tableCards.addLast(newTableCard);
                    } else {
                        tableCards.addFirst(newTableCard);
                    }
                } else {
                    if (move.isRight()) {
                        tableCards.addFirst(newTableCard);
                    } else {
                        tableCards.addLast(newTableCard);
                    }
                }
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        int player1Score = player1.getCollectedCardsCount();
        int player2Score = player2.getCollectedCardsCount();

        if (player1Score > player2Score) {
            return player1Score + " " + player2Score + " Jogador 1";
        } else if (player2Score > player1Score) {
            return player1Score + " " + player2Score + " Jogador 2";
        } else {
            return player1Score + " " + player2Score + " Empate";
        }
    }
}
