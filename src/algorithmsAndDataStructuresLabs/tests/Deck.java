package algorithmsAndDataStructuresLabs.tests;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    private Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
    }

    public void addCard(Card card) {
        cards.push(card);
    }

    public Card drawCard() {
        if (cards.isEmpty()) return null;
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void loadFromList(List<Card> cardList) {
        Collections.reverse(cardList); // Reverte a lista para que a primeira carta seja a do topo da pilha
        cards.addAll(cardList);
    }
}

