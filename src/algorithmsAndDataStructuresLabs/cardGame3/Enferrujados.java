package algorithmsAndDataStructuresLabs.cardGame3;

import java.io.*;
import java.util.*;

public class Enferrujados {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("/C://Users//Vini//Java//src//algorithmsAndDataStructuresLabs//cardGame3//partidas.txt/"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                List<String> cartasMonte = Arrays.asList(linha.split(" "));
                jogarPartida(cartasMonte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jogarPartida(List<String> cartasMonte) {
        Deque<String> monteCompra = new ArrayDeque<>(cartasMonte); // Monte de cartas para compra (pilha)
        List<String> maoJogador1 = new LinkedList<>(); // Mão do jogador 1 (lista dinâmica)
        List<String> maoJogador2 = new LinkedList<>(); // Mão do jogador 2 (lista dinâmica)
        Deque<String> cartasMesa = new ArrayDeque<>(); // Cartas na mesa (deque)
        Deque<String> cartasColetadasJogador1 = new ArrayDeque<>(); // Cartas coletadas do jogador 1 (pilha)
        Deque<String> cartasColetadasJogador2 = new ArrayDeque<>(); // Cartas coletadas do jogador 2 (pilha)

        // Distribuir cartas iniciais
        distribuirCartas(monteCompra, maoJogador1, 4);
        distribuirCartas(monteCompra, maoJogador2, 4);
        distribuirCartas(monteCompra, cartasMesa, 4);

        boolean turnoJogador1 = true;
        while (!monteCompra.isEmpty()) {
            if (turnoJogador1) {
                realizarTurno(maoJogador1, cartasMesa, monteCompra, cartasColetadasJogador1, true);
            } else {
                realizarTurno(maoJogador2, cartasMesa, monteCompra, cartasColetadasJogador2, false);
            }
            turnoJogador1 = !turnoJogador1;
        }

        int cartasJogador1 = cartasColetadasJogador1.size();
        int cartasJogador2 = cartasColetadasJogador2.size();
        if (cartasJogador1 > cartasJogador2) {
            System.out.println(cartasJogador1 + " " + cartasJogador2 + " Jogador 1");
        } else if (cartasJogador2 > cartasJogador1) {
            System.out.println(cartasJogador1 + " " + cartasJogador2 + " Jogador 2");
        } else {
            System.out.println(cartasJogador1 + " " + cartasJogador2 + " Empate");
        }
    }

    private static void distribuirCartas(Deque<String> monteCompra, Collection<String> destino, int quantidade) {
        for (int i = 0; i < quantidade && !monteCompra.isEmpty(); i++) {
            destino.add(monteCompra.pop());
        }
    }

    private static void realizarTurno(List<String> maoJogador, Deque<String> cartasMesa, Deque<String> monteCompra,
                                      Deque<String> cartasColetadas, boolean isJogador1) {
        String cartaParaColetar = null;
        boolean coletou = false;
        if (isJogador1) {
            // Jogador 1 coleta a primeira carta que puder
            for (String carta : maoJogador) {
                if (cartasMesa.peekFirst() != null && carta.equals(cartasMesa.peekFirst())) {
                    cartaParaColetar = cartasMesa.peekFirst();
                    coletou = true;
                    break;
                } else if (cartasMesa.peekLast() != null && carta.equals(cartasMesa.peekLast())) {
                    cartaParaColetar = cartasMesa.peekLast();
                    coletou = true;
                    break;
                }
            }
        } else {
            // Jogador 2 coleta a carta que permite coletar o maior número de cartas
            int maxCartasColetadas = 0;
            for (String carta : maoJogador) {
                int numCartasEsquerda = contarCartasIguais(cartasMesa, carta, true);
                int numCartasDireita = contarCartasIguais(cartasMesa, carta, false);
                int maiorColeta = Math.max(numCartasEsquerda, numCartasDireita);
                if (maiorColeta > maxCartasColetadas) {
                    maxCartasColetadas = maiorColeta;
                    cartaParaColetar = carta;
                    coletou = true;
                }
            }
        }

        if (coletou) {
            maoJogador.remove(cartaParaColetar);
            cartasColetadas.push(cartaParaColetar);
            if (cartaParaColetar.equals(cartasMesa.peekFirst())) {
                cartasMesa.pollFirst();
            } else {
                cartasMesa.pollLast();
            }
        } else {
            if (isJogador1) {
                cartasMesa.addFirst(maoJogador.remove(0));
            } else {
                cartasMesa.addLast(maoJogador.remove(maoJogador.size() - 1));
            }
        }
        if (!monteCompra.isEmpty()) {
            maoJogador.add(monteCompra.pop());
        }
    }

    private static int contarCartasIguais(Deque<String> cartasMesa, String carta, boolean esquerda) {
        int count = 0;
        Iterator<String> it = esquerda ? cartasMesa.iterator() : cartasMesa.descendingIterator();
        while (it.hasNext()) {
            if (it.next().equals(carta)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}