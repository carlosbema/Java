package src.algorithmsAndDataStructuresLabs.exercises.enferrujados.entities;

import java.util.*;

public abstract class Player {
    protected List<Card> hand;
    protected Stack<Card> collectedCards;
    protected String name;

    public Player(String name) {
        this.hand = new LinkedList<>();
        this.collectedCards = new Stack<>();
        this.name = name;
    }

    public abstract TurnResult playTurn(Deque<Card> tableCards, Stack<Card> drawPile);

    public void drawCard(Stack<Card> drawPile) {
        if (!drawPile.isEmpty()) {
            Card card = drawPile.pop();
            hand.add(card);
        }
    }

    public int getCollectedCardsCount() {
        return collectedCards.size();
    }

    public String getName() {
        return name;
    }
}
