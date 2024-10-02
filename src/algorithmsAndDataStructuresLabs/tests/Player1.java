package algorithmsAndDataStructuresLabs.tests;

import java.util.ArrayList;
import java.util.List;

public class Player1 extends Player {

    public Player1() {
        super("Jogador 1");
    }

    @Override
    public boolean takeTurn(Table table, Deck deck) {
        boolean collected = false;
        Card usedCard = null;
        List<Card> collectedFromTable = new ArrayList<>();
        String collectEnd = null; // "left" ou "right"

        // Inspeciona as cartas da mão do primeiro ao último
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            int leftMatch = table.countMatchingLeft(card);
            int rightMatch = table.countMatchingRight(card);

            if (leftMatch > 0 || rightMatch > 0) {
                // Encontrou uma carta que permite coleta
                usedCard = hand.removeCard(i);
                if (leftMatch > 0 && rightMatch > 0) {
                    // Coleta na extremidade direita
                    collectEnd = "right";
                    collectedFromTable.addAll(table.removeMatchingRight(card));
                } else if (leftMatch > 0) {
                    collectEnd = "left";
                    collectedFromTable.addAll(table.removeMatchingLeft(card));
                } else {
                    collectEnd = "right";
                    collectedFromTable.addAll(table.removeMatchingRight(card));
                }
                collected = true;
                break;
            }
        }

        if (!collected) {
            // Não pode coletar, posiciona a primeira carta da mão na extremidade esquerda
            usedCard = hand.removeCard(0);
            table.addCardLeft(usedCard);
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
                table.addCardRight(cardToTable);
            }
            if (deck.isEmpty()) return true; // Fim do jogo
        } else {
            return true; // Fim do jogo
        }

        return false; // Jogo continua
    }
}

