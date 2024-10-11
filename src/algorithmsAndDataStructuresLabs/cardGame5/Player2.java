package algorithmsAndDataStructuresLabs.cardGame5;

import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

class Player2 extends Player {

    @Override
    public int playTurn(Deque<Card> tableCards, Stack<Card> deck) {
        boolean collected = false;
        int action; // Return value indicating action
        int maxCollectCount = 0;
        int chosenCardIndex = -1;
        boolean collectFromRight = false;

        // Inspects their cards, and chooses the one that allows collecting the largest number of cards.
        int handSize = hand.size();
        for (int i = 0; i < handSize; i++) {
            Card handCard = hand.get(i);

            // Check how many cards can be collected from the left end
            int leftMatchCount = 0;
            Card leftMostCard = tableCards.peekFirst();
            if (leftMostCard != null && handCard.getName().equals(leftMostCard.getName())) {
                for (Card card : tableCards) {
                    if (card.getName().equals(handCard.getName())) {
                        leftMatchCount++;
                    } else {
                        break;
                    }
                }
            }

            // Check how many cards can be collected from the right end
            int rightMatchCount = 0;
            Card rightMostCard = tableCards.peekLast();
            if (rightMostCard != null && handCard.getName().equals(rightMostCard.getName())) {
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

            // Determine the maximum number of cards that can be collected with this handCard
            int maxMatches = Math.max(leftMatchCount, rightMatchCount);
            if (maxMatches > maxCollectCount) {
                maxCollectCount = maxMatches;
                chosenCardIndex = i;
                collectFromRight = (leftMatchCount > 0 && rightMatchCount > 0) || (rightMatchCount >= leftMatchCount);
            } else if (maxMatches == maxCollectCount && maxMatches > 0) {
                // In case of tie, choose the one that comes first in their hand
                if (chosenCardIndex == -1 || i < chosenCardIndex) {
                    chosenCardIndex = i;
                    collectFromRight = (leftMatchCount > 0 && rightMatchCount > 0) || (rightMatchCount >= leftMatchCount);
                }
            }
        }

        if (maxCollectCount > 0 && chosenCardIndex != -1) {
            // Found a card that can collect
            Card handCard = hand.get(chosenCardIndex);
            if (collectFromRight) {
                // Collect from the right end
                collectFromRight(tableCards, handCard);
            } else {
                // Collect from the left end
                collectFromLeft(tableCards, handCard);
            }
            hand.remove(chosenCardIndex); // Remove the used card from hand
            collected = true;
            action = lastAction;
        } else {
            // Cannot collect, select the last card from hand and place it at the right end
            Card cardToPlace = hand.removeLast();
            tableCards.addLast(cardToPlace);
            lastAction = 2; // Placed on right
            action = lastAction;
        }

        // At the end of their turn, the player always draws a card from the deck and adds it to the end of their hand.
        if (!deck.isEmpty()) {
            Card drawnCard = deck.pop();
            hand.addLast(drawnCard);
        }

        return action;
    }

    private void collectFromLeft(Deque<Card> tableCards, Card handCard) {
        lastAction = -1;
        // Use handCard and collect matching cards from left
        collectedCards.push(handCard); // Add the card used from hand to collected cards

        while (!tableCards.isEmpty() && tableCards.peekFirst().getName().equals(handCard.getName())) {
            collectedCards.push(tableCards.removeFirst());
        }
    }

    private void collectFromRight(Deque<Card> tableCards, Card handCard) {
        lastAction = 1;
        // Use handCard and collect matching cards from right
        collectedCards.push(handCard); // Add the card used from hand to collected cards

        while (!tableCards.isEmpty() && tableCards.peekLast().getName().equals(handCard.getName())) {
            collectedCards.push(tableCards.removeLast());
        }
    }
}
