package algorithmsAndDataStructuresLabs.cardGame2.entities;

import java.util.Collection;
import java.util.Deque;
import java.util.Stack;

public class Baralho extends Stack<Carta> {

    // Monte de cartas para compra: pilha (extende Stack<Carta>)

    public void distribuirCartas(Deque<Carta> destino, int quantidade) {
        for (int i = 0; i < quantidade && !this.isEmpty(); i++) {
            destino.addLast(this.pop());
        }
    }
}

