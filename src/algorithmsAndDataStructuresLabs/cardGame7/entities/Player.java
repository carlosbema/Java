package algorithmsAndDataStructuresLabs.cardGame7.entities;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public abstract class Player {
    protected List<Card> hand;
    protected Stack<Card> collectedCards;
    protected int playerNumber;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        this.hand = new ArrayList<>();
        this.collectedCards = new Stack<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void collectCards(List<Card> cards) {
        collectedCards.addAll(cards);
    }

    public int getCollectedCardsCount() {
        return collectedCards.size();
    }

    public abstract Move makeMove(Deque<Card> tableCards);
}
