package algorithmsAndDataStructuresLabs.cardGame2.entities;

import java.util.*;

public class Jogador {

    private int id;
    private LinkedList<Carta> mao;            // Cartas na mão: lista dinâmica
    private Stack<Carta> cartasColetadas;     // Cartas coletadas: pilha

    public Jogador(int id) {
        this.id = id;
        this.mao = new LinkedList<>();
        this.cartasColetadas = new Stack<>();
    }

    public void jogarTurno(Baralho monteCompra, Deque<Carta> mesa) {
        if (id == 1) {
            jogarTurnoJogador1(monteCompra, mesa);
        } else {
            jogarTurnoJogador2(monteCompra, mesa);
        }
    }

    private void jogarTurnoJogador1(Baralho monteCompra, Deque<Carta> mesa) {
        boolean coletou = false;
        Carta cartaUsada = null;

        for (Carta cartaMao : mao) {
            boolean podeColetarEsquerda = !mesa.isEmpty() && mesa.peekFirst().equals(cartaMao);
            boolean podeColetarDireita = !mesa.isEmpty() && mesa.peekLast().equals(cartaMao);

            if (podeColetarEsquerda || podeColetarDireita) {
                cartaUsada = cartaMao;
                mao.remove(cartaUsada);
                if (podeColetarDireita) {
                    coletarCartas(mesa, cartaUsada, false);
                } else {
                    coletarCartas(mesa, cartaUsada, true);
                }
                coletou = true;
                break;
            }
        }

        if (!coletou) {
            cartaUsada = mao.removeFirst();
            mesa.addFirst(cartaUsada);
        }

        if (!monteCompra.isEmpty()) {
            mao.addLast(monteCompra.pop());
        }

        adicionarCartaMesa(monteCompra, mesa, coletou, false);
    }

    private void jogarTurnoJogador2(Baralho monteCompra, Deque<Carta> mesa) {
        boolean coletou = false;
        Carta cartaUsada = null;
        int maxCartasColetadas = 0;
        Carta cartaEscolhida = null;

        for (Carta cartaMao : mao) {
            int numColetaEsquerda = contarCartasColetaveis(mesa, cartaMao, true);
            int numColetaDireita = contarCartasColetaveis(mesa, cartaMao, false);
            int maxColetavel = Math.max(numColetaEsquerda, numColetaDireita);

            if (maxColetavel > 0 && maxColetavel > maxCartasColetadas) {
                maxCartasColetadas = maxColetavel;
                cartaEscolhida = cartaMao;
            }
        }

        if (cartaEscolhida != null) {
            mao.remove(cartaEscolhida);
            boolean coletaDireita = mesa.peekLast().equals(cartaEscolhida);

            if (coletaDireita) {
                coletarCartas(mesa, cartaEscolhida, false);
            } else {
                coletarCartas(mesa, cartaEscolhida, true);
            }
            coletou = true;
        }

        if (!coletou) {
            cartaUsada = mao.removeLast();
            mesa.addLast(cartaUsada);
        }

        if (!monteCompra.isEmpty()) {
            mao.addLast(monteCompra.pop());
        }

        adicionarCartaMesa(monteCompra, mesa, coletou, true);
    }

    private void coletarCartas(Deque<Carta> mesa, Carta cartaUsada, boolean esquerda) {
        cartasColetadas.push(cartaUsada);

        if (esquerda) {
            while (!mesa.isEmpty() && mesa.peekFirst().equals(cartaUsada)) {
                cartasColetadas.push(mesa.pollFirst());
            }
        } else {
            while (!mesa.isEmpty() && mesa.peekLast().equals(cartaUsada)) {
                cartasColetadas.push(mesa.pollLast());
            }
        }
    }

    private int contarCartasColetaveis(Deque<Carta> mesa, Carta carta, boolean esquerda) {
        int contador = 0;
        Iterator<Carta> iterator;
        if (esquerda) {
            iterator = mesa.iterator();
        } else {
            iterator = mesa.descendingIterator();
        }

        while (iterator.hasNext()) {
            Carta cartaMesa = iterator.next();
            if (cartaMesa.equals(carta)) {
                contador++;
            } else {
                break;
            }
        }
        return contador;
    }

    private void adicionarCartaMesa(Baralho monteCompra, Deque<Carta> mesa, boolean coletou, boolean jogador2) {
        if (monteCompra.isEmpty()) {
            return;
        }
        Carta cartaMesa = monteCompra.pop();

        if (coletou) {
            if (jogador2) {
                mesa.addLast(cartaMesa);
            } else {
                mesa.addLast(cartaMesa);
            }
        } else {
            if (jogador2) {
                mesa.addFirst(cartaMesa);
            } else {
                mesa.addLast(cartaMesa);
            }
        }
    }

    public LinkedList<Carta> getMao() {
        return mao;
    }

    public Stack<Carta> getCartasColetadas() {
        return cartasColetadas;
    }
}

