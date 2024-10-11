package algorithmsAndDataStructuresLabs.cardGame5;

import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

class Player1 extends Player {

    @Override
    public int playTurn(Deque<Card> tableCards, Stack<Card> deck) {
        boolean collected = false;
        int action; // Return value indicating action

        // Inspects their cards from the first to the last, and chooses the first card that allows a collection.
        int handSize = hand.size();
        for (int i = 0; i < handSize; i++) {
            Card handCard = hand.get(i);

            // Check if the handCard matches the left end
            Card leftMostCard = tableCards.peekFirst();
            int leftMatchCount = 0;
            if (leftMostCard != null && handCard.getName().equals(leftMostCard.getName())) {
                // Count how many matching cards at the left end
                for (Card card : tableCards) {
                    if (card.getName().equals(handCard.getName())) {
                        leftMatchCount++;
                    } else {
                        break; // Stop when cards differ
                    }
                }
            }

            // Check if the handCard matches the right end
            Card rightMostCard = tableCards.peekLast();
            int rightMatchCount = 0;
            if (rightMostCard != null && handCard.getName().equals(rightMostCard.getName())) {
                // Count how many matching cards at the right end (from the end)
                Iterator<Card> descIter = tableCards.descendingIterator();
                while (descIter.hasNext()) {
                    Card card = descIter.next();
                    if (card.getName().equals(handCard.getName())) {
                        rightMatchCount++;
                    } else {
                        break;
                    }
                }
            }

            if (leftMatchCount > 0 || rightMatchCount > 0) {
                // Found a card that can collect
                // If the chosen card allows collection at both ends, collects from the right end.
                if (leftMatchCount > 0 && rightMatchCount > 0) {
                    // Collect from the right end
                    collectFromRight(tableCards, handCard, rightMatchCount);
                } else if (rightMatchCount > 0) {
                    // Collect from the right end
                    collectFromRight(tableCards, handCard, rightMatchCount);
                } else {
                    // Collect from the left end
                    collectFromLeft(tableCards, handCard, leftMatchCount);
                }
                hand.remove(i); // Remove the used card from hand
                collected = true;
                break; // End the turn after collecting
            }
        }

        if (collected) {
            action = lastAction;
        } else {
            // Cannot collect, select the first card from hand and place it at the left end
            Card cardToPlace = hand.removeFirst();
            tableCards.addFirst(cardToPlace);
            lastAction = 0; // Placed on left
            action = lastAction;
        }

        // At the end of their turn, the player always draws a card from the deck and adds it to the end of their hand.
        if (!deck.isEmpty()) {
            Card drawnCard = deck.pop();
            hand.addLast(drawnCard);
        }

        return action;
    }

    private void collectFromLeft(Deque<Card> tableCards, Card handCard, int count) {
        lastAction = -1;
        // Use handCard and collect count cards from left
        collectedCards.push(handCard); // Add the card used from hand to collected cards

        for (int i = 0; i < count; i++) {
            collectedCards.push(tableCards.removeFirst());
        }
    }

    private void collectFromRight(Deque<Card> tableCards, Card handCard, int count) {
        lastAction = 1;
        // Use handCard and collect count cards from right
        collectedCards.push(handCard); // Add the card used from hand to collected cards

        for (int i = 0; i < count; i++) {
            collectedCards.push(tableCards.removeLast());
        }
    }
}
