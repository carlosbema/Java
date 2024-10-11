package algorithmsAndDataStructuresLabs.cardGame7.entities;

import java.util.Deque;

public class Player1 extends Player {
    public Player1() {
        super(1);
    }

    @Override
    public Move makeMove(Deque<Card> tableCards) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            if (card.equals(tableCards.peekFirst())) {
                hand.remove(i);
                return new Move(card, true, false);
            } else if (card.equals(tableCards.peekLast())) {
                hand.remove(i);
                return new Move(card, true, true);
            }
        }

        Card cardToPlay = hand.remove(0);
        return new Move(cardToPlay, false, false);
    }
}
