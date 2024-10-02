package algorithmsAndDataStructuresLabs.tests;

import java.util.Stack;

public abstract class Player {
    protected String name;
    protected Hand hand;
    protected Stack<Card> collectedCards;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.collectedCards = new Stack<>();
    }

    public abstract boolean takeTurn(Table table, Deck deck);

    public int getCollectedCardsCount() {
        return collectedCards.size();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
}

