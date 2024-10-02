package algorithmsAndDataStructuresLabs.tests;

import java.util.List;

public class Game {
    private Deck deck;
    private Table table;
    private Player player1;
    private Player player2;

    public Game(List<Card> deckCards) {
        deck = new Deck();
        deck.loadFromList(deckCards);
        table = new Table();
        player1 = new Player1();
        player2 = new Player2();
    }

    public String play() {
        // Distribui cartas para os jogadores e para a mesa
        for (int i = 0; i < 4; i++) {
            player1.getHand().addCard(deck.drawCard());
        }
        for (int i = 0; i < 4; i++) {
            player2.getHand().addCard(deck.drawCard());
        }
        for (int i = 0; i < 4; i++) {
            table.addCardRight(deck.drawCard());
        }

        boolean gameOver = false;
        boolean player1Turn = true;

        while (!gameOver) {
            if (player1Turn) {
                gameOver = player1.takeTurn(table, deck);
                if (gameOver) break;
            } else {
                gameOver = player2.takeTurn(table, deck);
                if (gameOver) break;
            }
            player1Turn = !player1Turn;
        }

        // Determina o vencedor
        int player1Collected = player1.getCollectedCardsCount();
        int player2Collected = player2.getCollectedCardsCount();

        String winner;
        if (player1Collected > player2Collected) {
            winner = "Jogador 1";
        } else if (player2Collected > player1Collected) {
            winner = "Jogador 2";
        } else {
            winner = "Empate";
        }

        // Retorna o resultado
        return player1Collected + " " + player2Collected + " " + winner;
    }
}

