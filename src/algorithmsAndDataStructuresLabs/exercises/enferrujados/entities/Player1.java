package src.algorithmsAndDataStructuresLabs.exercises.enferrujados.entities;

import java.util.Deque;
import java.util.Stack;

public class Player1 extends Player {

    public Player1(String name) {
        super(name);
    }

    @Override
    public TurnResult playTurn(Deque<Card> tableCards, Stack<Card> drawPile) {
        TurnResult result = new TurnResult();
        boolean collected = false;
        int handSize = hand.size();
        for (int i = 0; i < handSize; i++) {
            Card handCard = hand.get(i);

            boolean canCollectLeft = !tableCards.isEmpty() && handCard.equals(tableCards.peekFirst());
            boolean canCollectRight = !tableCards.isEmpty() && handCard.equals(tableCards.peekLast());

            if (canCollectLeft || canCollectRight) {
                if (canCollectRight) {
                    collectCards(handCard, tableCards, false);
                    result.collected = true;
                    result.collectedFromLeft = false;
                } else {
                    collectCards(handCard, tableCards, true);
                    result.collected = true;
                    result.collectedFromLeft = true;
                }
                hand.remove(i);
                collected = true;
                break;
            }
        }
        if (!collected) {
            if (!hand.isEmpty()) {
                Card cardToPlace = hand.remove(0);
                tableCards.addFirst(cardToPlace);
                result.placedCard = true;
                result.placedOnLeft = true;
            }
        }
        return result;
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
