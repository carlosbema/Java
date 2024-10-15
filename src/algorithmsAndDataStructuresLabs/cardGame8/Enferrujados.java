package algorithmsAndDataStructuresLabs.cardGame8;

import java.io.*;
import java.util.*;

public class Enferrujados {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src//partidas.txt"));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] cartas = linha.split(" ");
            // Monte de cartas para compra com pilha
            Stack<String> monte = new Stack<>();
            for (int i = cartas.length - 1; i >= 0; i--) {
                monte.push(cartas[i]);
            }
            simularPartida(monte);
        }
        reader.close();
    }

    public static void simularPartida(Stack<String> monte) {
        // Mão dos jogadores com listas
        LinkedList<String> maoJogador1 = new LinkedList<>();
        LinkedList<String> maoJogador2 = new LinkedList<>();
        // Cartas na mesa: usando deque (ArrayDeque)
        Deque<String> mesa = new ArrayDeque<>();
        // Cartas coletadas com pilhas
        Stack<String> coletadasJogador1 = new Stack<>();
        Stack<String> coletadasJogador2 = new Stack<>();

        // Distribuir as cartas iniciais
        for (int i = 0; i < 4; i++) {
            maoJogador1.add(monte.pop());
        }
        for (int i = 0; i < 4; i++) {
            maoJogador2.add(monte.pop());
        }
        for (int i = 0; i < 4; i++) {
            mesa.addLast(monte.pop());
        }

        boolean turnoJogador1 = true;
        while (!monte.isEmpty()) {
            if (turnoJogador1) {
                executarTurno(maoJogador1, mesa, coletadasJogador1, monte, true);
            } else {
                executarTurno(maoJogador2, mesa, coletadasJogador2, monte, false);
            }
            turnoJogador1 = !turnoJogador1;
            if (!monte.isEmpty()) {
                mesa.addLast(monte.pop());
            }
        }

        // Imprimir resultado
        int coletadas1 = coletadasJogador1.size();
        int coletadas2 = coletadasJogador2.size();
        if (coletadas1 > coletadas2) {
            System.out.println(coletadas1 + " " + coletadas2 + " Jogador 1");
        } else if (coletadas2 > coletadas1) {
            System.out.println(coletadas1 + " " + coletadas2 + " Jogador 2");
        } else {
            System.out.println(coletadas1 + " " + coletadas2 + " Empate");
        }
    }

    public static void executarTurno(LinkedList<String> mao, Deque<String> mesa, Stack<String> coletadas, Stack<String> monte, boolean jogador1) {
        boolean coletou = false;
        Iterator<String> iterator = mao.iterator();
        while (iterator.hasNext()) {
            String carta = iterator.next();
            if (carta.equals(mesa.peekFirst())) {
                coletarCartas(mesa, coletadas, iterator, true);
                coletou = true;
                break;
            } else if (carta.equals(mesa.peekLast())) {
                coletarCartas(mesa, coletadas, iterator, false);
                coletou = true;
                break;
            }
        }

        if (!coletou) {
            if (jogador1) {
                // Jogador 1 posiciona a carta na extremidade esquerda da mesa
                mesa.addFirst(mao.removeFirst());
            } else {
                // Jogador 2 posiciona a carta na extremidade direita da mesa
                mesa.addLast(mao.removeLast());
            }
        }
        // Jogador compra uma carta do monte e adiciona ao final da mão
        mao.addLast(monte.pop());
    }

    public static void coletarCartas(Deque<String> mesa, Stack<String> coletadas, Iterator<String> iterator, boolean esquerda) {
        // Remove a carta da mão do jogador
        iterator.remove();
        if (esquerda) {
            // Coletar todas as cartas iguais consecutivas da extremidade esquerda
            String primeiraCarta = mesa.pollFirst();
            coletadas.push(primeiraCarta);
            while (!mesa.isEmpty() && mesa.peekFirst().equals(primeiraCarta)) {
                coletadas.push(mesa.pollFirst());
            }
        } else {
            // Coletar todas as cartas iguais consecutivas da extremidade direita
            String ultimaCarta = mesa.pollLast();
            coletadas.push(ultimaCarta);
            while (!mesa.isEmpty() && mesa.peekLast().equals(ultimaCarta)) {
                coletadas.push(mesa.pollLast());
            }
        }
    }
}
