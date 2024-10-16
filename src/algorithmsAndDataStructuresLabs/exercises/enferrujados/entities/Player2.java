package src.algorithmsAndDataStructuresLabs.exercises.enferrujados.entities;

import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class Player2 extends Player {

    public Player2(String name) {
        super(name);
    }

    @Override
    public TurnResult playTurn(Deque<Card> tableCards, Stack<Card> drawPile) {
        TurnResult result = new TurnResult();
        boolean collected = false;
        int maxCollect = 0;
        int selectedCardIndex = -1;
        boolean collectFromLeft = false;

        for (int i = 0; i < hand.size(); i++) {
            Card handCard = hand.get(i);

            int collectLeft = countCollectableCards(handCard, tableCards, true);
            int collectRight = countCollectableCards(handCard, tableCards, false);

            int totalCollect = Math.max(collectLeft, collectRight);
            if (totalCollect > maxCollect) {
                maxCollect = totalCollect;
                selectedCardIndex = i;
                collectFromLeft = (collectLeft >= collectRight) ? collectLeft > collectRight : false;
            } else if (totalCollect == maxCollect && selectedCardIndex == -1) {
                selectedCardIndex = i;
                collectFromLeft = (collectLeft >= collectRight) ? collectLeft > collectRight : false;
            }
        }
        if (maxCollect > 0) {
            Card handCard = hand.remove(selectedCardIndex);
            if (collectFromLeft) {
                collectCards(handCard, tableCards, true);
                result.collected = true;
                result.collectedFromLeft = true;
            } else {
                collectCards(handCard, tableCards, false);
                result.collected = true;
                result.collectedFromLeft = false;
            }
            collected = true;
        }
        if (!collected) {
            if (!hand.isEmpty()) {
                Card cardToPlace = hand.remove(hand.size() - 1);
                tableCards.addLast(cardToPlace);
                result.placedCard = true;
                result.placedOnLeft = false;
            }
        }
        return result;
    }

    private int countCollectableCards(Card handCard, Deque<Card> tableCards, boolean fromLeft) {
        int count = 0;
        Iterator<Card> iterator = fromLeft ? tableCards.iterator() : tableCards.descendingIterator();
        while (iterator.hasNext()) {
            Card tableCard = iterator.next();
            if (handCard.equals(tableCard)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private void collectCards(Card handCard, Deque<Card> tableCards, boolean collectFromLeft) {
        collectedCards.push(handCard);
        if (collectFromLeft) {
            while (!tableCards.isEmpty() && handCard.equals(tableCards.peekFirst())) {
                collectedCards.push(tableCards.removeFirst());
            }
        } else {
            while (!tableCards.isEmpty() && handCard.equals(tableCards.peekLast())) {
                collectedCards.push(tableCards.removeLast());
            }
        }
    }
}
