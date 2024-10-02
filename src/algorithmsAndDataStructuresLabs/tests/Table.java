package algorithmsAndDataStructuresLabs.tests;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Table {
    private Deque<Card> cards;

    public Table() {
        cards = new ArrayDeque<>();
    }

    public void addCardLeft(Card card) {
        cards.addFirst(card);
    }

    public void addCardRight(Card card) {
        cards.addLast(card);
    }

    public Card peekLeft() {
        return cards.peekFirst();
    }

    public Card peekRight() {
        return cards.peekLast();
    }

    public List<Card> removeMatchingLeft(Card card) {
        List<Card> collected = new ArrayList<>();
        while (!cards.isEmpty() && cards.peekFirst().equals(card)) {
            collected.add(cards.removeFirst());
        }
        return collected;
    }

    public List<Card> removeMatchingRight(Card card) {
        List<Card> collected = new ArrayList<>();
        while (!cards.isEmpty() && cards.peekLast().equals(card)) {
            collected.add(cards.removeLast());
        }
        return collected;
    }

    public int countMatchingLeft(Card card) {
        int count = 0;
        if (cards.isEmpty()) return count;
        Iterator<Card> iterator = cards.iterator();
        Card firstCard = cards.peekFirst();
        while (iterator.hasNext()) {
            Card c = iterator.next();
            if (c.equals(firstCard)) {
                if (c.equals(card)) {
                    count++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return count;
    }

    public int countMatchingRight(Card card) {
        int count = 0;
        if (cards.isEmpty()) return count;
        Iterator<Card> iterator = cards.descendingIterator();
        Card lastCard = cards.peekLast();
        while (iterator.hasNext()) {
            Card c = iterator.next();
            if (c.equals(lastCard)) {
                if (c.equals(card)) {
                    count++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return count;
    }
}

