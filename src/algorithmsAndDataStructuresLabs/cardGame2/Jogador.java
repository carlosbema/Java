package algorithmsAndDataStructuresLabs.cardGame2;

import java.util.*;

public class Jogador {
    private LinkedList<String> mao;
    private Stack<String> coletadas;
    private boolean jogador1; // Indica se é o jogador 1 ou 2

    public Jogador(boolean jogador1) {
        this.jogador1 = jogador1;
        mao = new LinkedList<>();
        coletadas = new Stack<>();
    }

    public void receberCarta(String carta) {
        mao.addLast(carta);
    }

    public int getNumeroCartasColetadas() {
        return coletadas.size();
    }

    public void executarTurno(Mesa mesa, Stack<String> monte) {
        boolean coletou = false;
        Iterator<String> iterator = mao.iterator();
        while (iterator.hasNext()) {
            String carta = iterator.next();
            if (carta.equals(mesa.verPrimeiraCarta())) {
                mesa.coletarCartas(coletadas, iterator, true);
                coletou = true;
                break;
            } else if (carta.equals(mesa.verUltimaCarta())) {
                mesa.coletarCartas(coletadas, iterator, false);
                coletou = true;
                break;
            }
        }

        if (!coletou) {
            if (jogador1) {
                mesa.adicionarCartaEsquerda(mao.removeFirst());
            } else {
                mesa.adicionarCartaDireita(mao.removeLast());
            }
        }
        // Jogador compra uma carta do monte e adiciona ao final da mão
        mao.addLast(monte.pop());
    }
}
