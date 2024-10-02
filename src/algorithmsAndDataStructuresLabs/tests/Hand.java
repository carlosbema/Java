package algorithmsAndDataStructuresLabs.tests;

import java.util.LinkedList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new LinkedList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeCard(int index) {
        return cards.remove(index);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }
}

