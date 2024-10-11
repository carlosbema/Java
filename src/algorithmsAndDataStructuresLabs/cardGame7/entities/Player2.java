package algorithmsAndDataStructuresLabs.cardGame7.entities;

import java.util.ArrayList;
import java.util.Deque;

public class Player2 extends Player {
    public Player2() {
        super(2);
    }

    @Override
    public Move makeMove(Deque<Card> tableCards) {
        Move bestMove = null;
        int maxCollectCount = 0;

        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            int leftCount = countCollectableCards(card, tableCards, true);
            int rightCount = countCollectableCards(card, tableCards, false);

            if (leftCount > maxCollectCount || rightCount > maxCollectCount) {
                maxCollectCount = Math.max(leftCount, rightCount);
                bestMove = new Move(card, true, rightCount >= leftCount);
            }
        }

        if (bestMove != null) {
            hand.remove(bestMove.getCard());
            return bestMove;
        }

        Card cardToPlay = hand.remove(hand.size() - 1);
        return new Move(cardToPlay, false, true);
    }

    private int countCollectableCards(Card card, Deque<Card> tableCards, boolean fromLeft) {
        int count = 0;
        for (Card tableCard : (fromLeft ? tableCards : new ArrayList<>(tableCards).reversed())) {
            if (card.equals(tableCard)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
