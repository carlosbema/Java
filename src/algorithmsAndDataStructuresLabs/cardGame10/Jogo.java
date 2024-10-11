package algorithmsAndDataStructuresLabs.cardGame10;


import java.util.*;

// Classe que representa o jogo
class Jogo {
    private Stack<String> monte;
    private Deque<String> mesa;
    private Jogador jogador1;
    private Jogador jogador2;

    public Jogo(List<String> cartas) {
        inicializarJogo(cartas);
    }

    private void inicializarJogo(List<String> cartas) {
        // Inicialização dos jogadores
        jogador1 = new Jogador("Jogador 1", true);
        jogador2 = new Jogador("Jogador 2", false);

        // Inicialização do monte como pilha (Stack)
        monte = new Stack<>();
        // Reverter a lista de cartas para empilhar corretamente
        Collections.reverse(cartas);
        monte.addAll(cartas);

        // Distribuição inicial
        // Cartas para jogador 1
        for (int i = 0; i < 4; i++) {
            jogador1.receberCarta(monte.pop());
        }
        // Cartas para jogador 2
        for (int i = 0; i < 4; i++) {
            jogador2.receberCarta(monte.pop());
        }
        // Cartas para a mesa (Deque)
        mesa = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            mesa.addLast(monte.pop());
        }
    }

    public void simularPartida() {
        boolean turnoJogador1 = true;

        while (!monte.isEmpty() || !jogador1.maoVazia() || !jogador2.maoVazia()) {
            if (turnoJogador1 && !jogador1.maoVazia()) {
                jogador1.executarTurno(mesa, monte);
            } else if (!turnoJogador1 && !jogador2.maoVazia()) {
                jogador2.executarTurno(mesa, monte);
            }
            turnoJogador1 = !turnoJogador1;
        }

        // Determinar o vencedor
        int totalJogador1 = jogador1.getTotalCartasColetadas();
        int totalJogador2 = jogador2.getTotalCartasColetadas();

        System.out.println("Resultado da partida:");
        System.out.println(jogador1.getNome() + " coletou " + totalJogador1 + " cartas.");
        System.out.println(jogador2.getNome() + " coletou " + totalJogador2 + " cartas.");

        if (totalJogador1 > totalJogador2) {
            System.out.println("Vencedor: " + jogador1.getNome());
        } else if (totalJogador2 > totalJogador1) {
            System.out.println("Vencedor: " + jogador2.getNome());
        } else {
            System.out.println("A partida terminou empatada.");
        }
    }
}