package algorithmsAndDataStructuresLabs.cardGame2;

import java.util.*;

public class Mesa {
    private Deque<String> cartasNaMesa;

    public Mesa() {
        cartasNaMesa = new ArrayDeque<>();
    }

    public void colocarCartaNaMesa(String carta) {
        cartasNaMesa.addLast(carta);
    }

    public String verPrimeiraCarta() {
        return cartasNaMesa.peekFirst();
    }

    public String verUltimaCarta() {
        return cartasNaMesa.peekLast();
    }

    public void adicionarCartaEsquerda(String carta) {
        cartasNaMesa.addFirst(carta);
    }

    public void adicionarCartaDireita(String carta) {
        cartasNaMesa.addLast(carta);
    }

    public void coletarCartas(Stack<String> coletadas, Iterator<String> iterator, boolean esquerda) {
        iterator.remove();
        if (esquerda) {
            coletadas.push(cartasNaMesa.pollFirst());
        } else {
            coletadas.push(cartasNaMesa.pollLast());
        }
    }
}
