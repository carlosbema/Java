package algorithmsAndDataStructuresLabs.cardGame2.entities;

import java.util.*;

public class Jogo {

    private Baralho monteCompra; // Monte de cartas para compra: pilha
    private Deque<Carta> mesa;   // Cartas da mesa: deque
    private Jogador jogador1;
    private Jogador jogador2;

    public Jogo(String linhaBaralho) {
        // Inicializa o monte de compra (pilha)
        this.monteCompra = new Baralho();
        String[] cartasArray = linhaBaralho.split(" ");
        // Inverte o array para empilhar na ordem correta
        for (int i = cartasArray.length - 1; i >= 0; i--) {
            monteCompra.push(new Carta(cartasArray[i]));
        }

        // Inicializa os jogadores
        this.jogador1 = new Jogador(1);
        this.jogador2 = new Jogador(2);

        // Inicializa a mesa (deque)
        this.mesa = new LinkedList<>();

        // Distribui as cartas iniciais
        monteCompra.distribuirCartas(jogador1.getMao(), 4);
        monteCompra.distribuirCartas(jogador2.getMao(), 4);
        monteCompra.distribuirCartas(mesa, 4);
    }

    public String jogar() {
        boolean jogoTerminado = false;
        boolean vezJogador1 = true;

        while (!jogoTerminado) {
            if (vezJogador1) {
                jogador1.jogarTurno(monteCompra, mesa);
            } else {
                jogador2.jogarTurno(monteCompra, mesa);
            }

            vezJogador1 = !vezJogador1;

            // Verifica se o jogo terminou
            if (monteCompra.isEmpty()) {
                jogoTerminado = true;
            }
        }

        int totalJogador1 = jogador1.getCartasColetadas().size();
        int totalJogador2 = jogador2.getCartasColetadas().size();

        String vencedor;
        if (totalJogador1 > totalJogador2) {
            vencedor = "Jogador 1";
        } else if (totalJogador2 > totalJogador1) {
            vencedor = "Jogador 2";
        } else {
            vencedor = "Empate";
        }

        return totalJogador1 + " " + totalJogador2 + " " + vencedor;
    }
}
