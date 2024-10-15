package algorithmsAndDataStructuresLabs.cardGame;

import java.io.*;
import java.util.*;

public class Enferrujados {

    // Definição de constantes para os jogadores
    private static final int JOGADOR_1 = 1;
    private static final int JOGADOR_2 = 2;

    public static void main(String[] args) throws IOException {
        // Leitura do arquivo de entrada
        BufferedReader reader = new BufferedReader(new FileReader("src//partidas.txt"));
        String linha;

        // Processa cada monte de cartas
        while ((linha = reader.readLine()) != null) {
            String[] cartas = linha.split(" ");
            simularPartida(cartas);
        }
        reader.close();
    }

    // Função para simular uma partida
    private static void simularPartida(String[] cartasMonte) {
        Stack<String> monte = inicializarMonte(cartasMonte); // Pilha do monte de cartas
        LinkedList<String> maoJogador1 = new LinkedList<>();
        LinkedList<String> maoJogador2 = new LinkedList<>();
        Deque<String> mesa = new LinkedList<>();
        Stack<String> coletadasJogador1 = new Stack<>();
        Stack<String> coletadasJogador2 = new Stack<>();

        // Distribui cartas iniciais
        distribuirCartas(monte, maoJogador1, maoJogador2, mesa);

        // Simula os turnos do jogo até o monte esvaziar
        while (!monte.isEmpty()) {
            turno(JOGADOR_1, maoJogador1, mesa, coletadasJogador1, monte);
            if (monte.isEmpty()) break;
            turno(JOGADOR_2, maoJogador2, mesa, coletadasJogador2, monte);
        }

        // Exibe o resultado final da partida
        exibirResultado(coletadasJogador1.size(), coletadasJogador2.size());
    }

    // Função para inicializar o monte de cartas
    private static Stack<String> inicializarMonte(String[] cartasMonte) {
        Stack<String> monte = new Stack<>();
        for (int i = cartasMonte.length - 1; i >= 0; i--) {
            monte.push(cartasMonte[i]);
        }
        return monte;
    }

    // Função para distribuir cartas no início do jogo
    private static void distribuirCartas(Stack<String> monte, LinkedList<String> maoJogador1,
                                         LinkedList<String> maoJogador2, Deque<String> mesa) {
        for (int i = 0; i < 4; i++) {
            maoJogador1.add(monte.pop());
            maoJogador2.add(monte.pop());
        }
        for (int i = 0; i < 4; i++) {
            mesa.add(monte.pop());
        }
    }

    // Função para executar o turno de um jogador
    private static void turno(int jogador, LinkedList<String> mao, Deque<String> mesa,
                              Stack<String> coletadas, Stack<String> monte) {
        boolean coletou = false;

        // Logica do Jogador 1
        if (jogador == JOGADOR_1) {
            for (String carta : mao) {
                if (coletarCarta(mao, mesa, coletadas, carta, true)) {
                    coletou = true;
                    break;
                }
            }
            if (!coletou) {
                String cartaParaMesa = mao.removeFirst();
                mesa.addFirst(cartaParaMesa);
            }
        }

        // Logica do Jogador 2
        else {
            String melhorCarta = null;
            int maxColetas = 0;
            for (String carta : mao) {
                int coletas = contarCartasParaColeta(mesa, carta);
                if (coletas > maxColetas) {
                    melhorCarta = carta;
                    maxColetas = coletas;
                }
            }
            if (melhorCarta != null) {
                coletarCarta(mao, mesa, coletadas, melhorCarta, false);
                coletou = true;
            }
            if (!coletou) {
                String cartaParaMesa = mao.removeLast();
                mesa.addLast(cartaParaMesa);
            }
        }

        // Compra uma nova carta para o jogador
        if (!monte.isEmpty()) {
            mao.add(monte.pop());
        }
    }

    // Função para coletar cartas da mesa (incluindo múltiplas cartas iguais)
    private static boolean coletarCarta(LinkedList<String> mao, Deque<String> mesa, Stack<String> coletadas,
                                        String carta, boolean preferenciaDireita) {
        // Verifica a extremidade esquerda
        if (mesa.peekFirst().equals(carta)) {
            while (!mesa.isEmpty() && mesa.peekFirst().equals(carta)) {
                coletadas.push(mesa.removeFirst());  // Coleta todas as cartas iguais na extremidade esquerda
            }
            mao.remove(carta);  // Remove a carta da mão usada para coletar
            return true;
        }

        // Verifica a extremidade direita
        else if (mesa.peekLast().equals(carta)) {
            while (!mesa.isEmpty() && mesa.peekLast().equals(carta)) {
                coletadas.push(mesa.removeLast());  // Coleta todas as cartas iguais na extremidade direita
            }
            mao.remove(carta);  // Remove a carta da mão usada para coletar
            return true;
        }

        return false;  // Nenhuma carta foi coletada
    }


    // Função para contar cartas que podem ser coletadas
    private static int contarCartasParaColeta(Deque<String> mesa, String carta) {
        int count = 0;
        if (mesa.peekFirst().equals(carta)) count++;
        if (mesa.peekLast().equals(carta)) count++;
        return count;
    }

    // Exibe o resultado de uma partida
    private static void exibirResultado(int cartasJogador1, int cartasJogador2) {
        if (cartasJogador1 > cartasJogador2) {
            System.out.println(cartasJogador1 + " " + cartasJogador2 + " Jogador 1");
        } else if (cartasJogador2 > cartasJogador1) {
            System.out.println(cartasJogador1 + " " + cartasJogador2 + " Jogador 2");
        } else {
            System.out.println(cartasJogador1 + " " + cartasJogador2 + " Empate");
        }
    }
}
