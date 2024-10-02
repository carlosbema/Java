package algorithmsAndDataStructuresLabs.tests;

import java.util.ArrayList;
import java.util.List;

public class Player2 extends Player {

    public Player2() {
        super("Jogador 2");
    }

    @Override
    public boolean takeTurn(Table table, Deck deck) {
        boolean collected = false;
        Card usedCard = null;
        List<Card> collectedFromTable = new ArrayList<>();
        String collectEnd = null; // "left" ou "right"

        int maxCollect = 0;
        int chosenIndex = -1;
        Card chosenCard = null;
        String chosenEnd = null;

        // Inspeciona as cartas para encontrar a que permite coletar o maior número de cartas
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            int leftMatch = table.countMatchingLeft(card);
            int rightMatch = table.countMatchingRight(card);
            int totalMatch = Math.max(leftMatch, rightMatch);

            if (totalMatch > maxCollect) {
                maxCollect = totalMatch;
                chosenIndex = i;
                chosenCard = card;
                if (leftMatch > 0 && rightMatch > 0) {
                    chosenEnd = "right";
                } else if (leftMatch > 0) {
                    chosenEnd = "left";
                } else if (rightMatch > 0) {
                    chosenEnd = "right";
                }
            } else if (totalMatch == maxCollect && maxCollect > 0) {
                // Em caso de empate, escolhe a que vem primeiro na mão
                if (chosenIndex == -1 || i < chosenIndex) {
                    chosenIndex = i;
                    chosenCard = card;
                    if (leftMatch > 0 && rightMatch > 0) {
                        chosenEnd = "right";
                    } else if (leftMatch > 0) {
                        chosenEnd = "left";
                    } else if (rightMatch > 0) {
                        chosenEnd = "right";
                    }
                }
            }
        }

        if (maxCollect > 0) {
            // Pode coletar
            usedCard = hand.removeCard(chosenIndex);
            collectEnd = chosenEnd;
            if ("left".equals(collectEnd)) {
                collectedFromTable.addAll(table.removeMatchingLeft(chosenCard));
            } else {
                collectedFromTable.addAll(table.removeMatchingRight(chosenCard));
            }
            collected = true;
        } else {
            // Não pode coletar, posiciona a última carta da mão na extremidade direita
            usedCard = hand.removeCard(hand.size() - 1);
            table.addCardRight(usedCard);
        }

        if (collected) {
            // Adiciona a carta usada e as cartas coletadas à pilha de cartas coletadas
            collectedCards.push(usedCard);
            collectedCards.addAll(collectedFromTable);
        }

        // Compra uma carta do monte, se não estiver vazio
        if (!deck.isEmpty()) {
            hand.addCard(deck.drawCard());
            if (deck.isEmpty()) return true; // Fim do jogo
        } else {
            return true; // Fim do jogo
        }

        // Adiciona uma carta do monte à mesa
        if (!deck.isEmpty()) {
            Card cardToTable = deck.drawCard();
            if (collected) {
                // Posiciona na extremidade onde ocorreu a coleta
                if ("left".equals(collectEnd)) {
                    table.addCardLeft(cardToTable);
                } else {
                    table.addCardRight(cardToTable);
                }
            } else {
                // Posiciona na extremidade oposta à que o jogador posicionou uma carta
                table.addCardLeft(cardToTable);
            }
            if (deck.isEmpty()) return true; // Fim do jogo
        } else {
            return true; // Fim do jogo
        }

        return false; // Jogo continua
    }
}

