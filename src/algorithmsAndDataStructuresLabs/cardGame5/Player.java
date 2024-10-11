package algorithmsAndDataStructuresLabs.cardGame5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

abstract class Player {
    protected LinkedList<Card> hand; // Using LinkedList to represent the player's hand
    protected Stack<Card> collectedCards; // Using Stack to represent the player's collected cards
    public int lastAction; // -1: collected from left, 1: collected from right, 0: placed on left, 2: placed on right

    public Player() {
        hand = new LinkedList<>(); // Initialize the hand as a LinkedList
        collectedCards = new Stack<>(); // Initialize the collected cards as a Stack
        lastAction = 0;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public Stack<Card> getCollectedCards() {
        return collectedCards;
    }

    public void addCardToHand(Card card) {
        hand.addLast(card); // Add card to the end of the hand
    }

    public int getCollectedCardsCount() {
        return collectedCards.size();
    }

    public abstract int playTurn(Deque<Card> tableCards, Stack<Card> deck);
}
