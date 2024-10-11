package algorithmsAndDataStructuresLabs.cardGame5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Game {
    private Stack<Card> deck; // Stack representing the deck of cards to be drawn
    private Deque<Card> tableCards; // Deque representing the cards on the table
    private Player1 player1;
    private Player2 player2;

    public Game(Stack<Card> deck) {
        this.deck = deck; // Using Stack to represent the deck
        tableCards = new LinkedList<>(); // Using Deque (LinkedList implementation) for table cards
        player1 = new Player1();
        player2 = new Player2();
        initializeGame();
    }

    private void initializeGame() {
        // Deal 4 cards to player 1
        for (int i = 0; i < 4 && !deck.isEmpty(); i++) {
            player1.addCardToHand(deck.pop());
        }
        // Deal 4 cards to player 2
        for (int i = 0; i < 4 && !deck.isEmpty(); i++) {
            player2.addCardToHand(deck.pop());
        }
        // Place 4 cards on the table
        for (int i = 0; i < 4 && !deck.isEmpty(); i++) {
            tableCards.addLast(deck.pop());
        }
    }

    public void playGame() {
        boolean isPlayer1Turn = true;
        while (!deck.isEmpty() || !player1.getHand().isEmpty() || !player2.getHand().isEmpty()) {
            if (isPlayer1Turn) {
                int action = player1.playTurn(tableCards, deck);
                afterTurn(action);
            } else {
                int action = player2.playTurn(tableCards, deck);
                afterTurn(action);
            }
            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    private void afterTurn(int action) {
        if (!deck.isEmpty()) {
            Card card = deck.pop();
            if (action == -1) {
                // Collected from left, place card at left end
                tableCards.addFirst(card);
            } else if (action == 1) {
                // Collected from right, place card at right end
                tableCards.addLast(card);
            } else if (action == 0) {
                // Did not collect, placed card on left end, so place new card on right end
                tableCards.addLast(card);
            } else if (action == 2) {
                // Did not collect, placed card on right end, so place new card on left end
                tableCards.addFirst(card);
            }
        }
    }

    public int getPlayer1CollectedCardsCount() {
        return player1.getCollectedCardsCount();
    }

    public int getPlayer2CollectedCardsCount() {
        return player2.getCollectedCardsCount();
    }
}
