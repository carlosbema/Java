package algorithmsAndDataStructuresLabs.cardGame2;

import java.io.*;
import java.util.*;

public class Jogo {
    private Mesa mesa;
    private Jogador jogador1;
    private Jogador jogador2;
    private Stack<String> monte;

    public Jogo() {
        mesa = new Mesa();
        jogador1 = new Jogador(true); // Jogador 1
        jogador2 = new Jogador(false); // Jogador 2
        monte = new Stack<>();
    }

    public void iniciarJogo(String caminhoArquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] cartas = linha.split(" ");
            monte.clear();
            for (int i = cartas.length - 1; i >= 0; i--) {
                monte.push(cartas[i]);
            }
            distribuirCartasIniciais();
            simularPartida();
        }
        reader.close();
    }

    private void distribuirCartasIniciais() {
        for (int i = 0; i < 4; i++) {
            jogador1.receberCarta(monte.pop());
        }
        for (int i = 0; i < 4; i++) {
            jogador2.receberCarta(monte.pop());
        }
        for (int i = 0; i < 4; i++) {
            mesa.colocarCartaNaMesa(monte.pop());
        }
    }

    private void simularPartida() {
        boolean turnoJogador1 = true;
        while (!monte.isEmpty()) {
            if (turnoJogador1) {
                jogador1.executarTurno(mesa, monte);
            } else {
                jogador2.executarTurno(mesa, monte);
            }
            turnoJogador1 = !turnoJogador1;
            if (!monte.isEmpty()) {
                mesa.colocarCartaNaMesa(monte.pop());
            }
        }

        // Imprimir resultado
        int coletadas1 = jogador1.getNumeroCartasColetadas();
        int coletadas2 = jogador2.getNumeroCartasColetadas();
        if (coletadas1 > coletadas2) {
            System.out.println(coletadas1 + " " + coletadas2 + " Jogador 1");
        } else if (coletadas2 > coletadas1) {
            System.out.println(coletadas1 + " " + coletadas2 + " Jogador 2");
        } else {
            System.out.println(coletadas1 + " " + coletadas2 + " Empate");
        }
    }

    public static void main(String[] args) throws IOException {
        Jogo jogo = new Jogo();
        jogo.iniciarJogo("src//partidas.txt");
    }
}
