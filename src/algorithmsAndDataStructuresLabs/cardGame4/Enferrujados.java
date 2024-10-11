package algorithmsAndDataStructuresLabs.cardGame4;

import java.io.*;
import java.util.*;

// Classe representando uma carta de carro
class Carta {
    String nome;

    public Carta(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}

// Classe para representar um jogador
class Jogador {
    List<Carta> mao; // Lista dinâmica de cartas na mão
    Stack<Carta> coletadas; // Pilha de cartas coletadas
    String nome;

    public Jogador(String nome) {
        this.mao = new LinkedList<>(); // Usando LinkedList para representar a lista dinâmica
        this.coletadas = new Stack<>(); // Pilha para armazenar as cartas coletadas
        this.nome = nome;
    }

    public void adicionarCartaNaMao(Carta carta) {
        mao.add(carta);
    }

    public Carta removerCartaDaMao(int index) {
        return mao.remove(index);
    }

    public void coletarCarta(Carta carta) {
        coletadas.push(carta);
    }

    public int quantidadeColetada() {
        return coletadas.size();
    }
}

// Classe principal para gerenciar o jogo
public class Enferrujados {
    Stack<Carta> monte; // Pilha de cartas para compra
    Deque<Carta> mesa; // Deque para as cartas expostas na mesa
    Jogador jogador1;
    Jogador jogador2;

    public Enferrujados(List<Carta> cartasMonte) {
        monte = new Stack<>();
        mesa = new ArrayDeque<>();
        jogador1 = new Jogador("Jogador 1");
        jogador2 = new Jogador("Jogador 2");

        // Embaralhar e colocar cartas no monte (Pilha)
        Collections.shuffle(cartasMonte);
        monte.addAll(cartasMonte);

        // Distribuir as cartas iniciais para os jogadores
        distribuirCartasIniciais();
    }

    private void distribuirCartasIniciais() {
        for (int i = 0; i < 4; i++) {
            jogador1.adicionarCartaNaMao(monte.pop());
            jogador2.adicionarCartaNaMao(monte.pop());
            mesa.add(monte.pop());
        }
    }

    // Método para o comportamento do Jogador 1
    private void turnoJogador1() {
        boolean coletou = false;

        // Inspeciona a mão para ver se pode coletar cartas da mesa
        for (int i = 0; i < jogador1.mao.size(); i++) {
            Carta carta = jogador1.mao.get(i);
            if (podeColetar(carta, mesa.peekFirst())) {
                coletarCarta(jogador1, i, true);
                coletou = true;
                break;
            } else if (podeColetar(carta, mesa.peekLast())) {
                coletarCarta(jogador1, i, false);
                coletou = true;
                break;
            }
        }

        // Se não coletou, posiciona a primeira carta na extremidade esquerda
        if (!coletou) {
            Carta cartaUsada = jogador1.removerCartaDaMao(0);
            mesa.addFirst(cartaUsada);
        }

        // Comprar uma nova carta
        jogador1.adicionarCartaNaMao(monte.pop());
    }

    // Método para o comportamento do Jogador 2
    private void turnoJogador2() {
        boolean coletou = false;

        // Inspeciona a mão para ver se pode coletar cartas da mesa
        for (int i = 0; i < jogador2.mao.size(); i++) {
            Carta carta = jogador2.mao.get(i);
            if (podeColetar(carta, mesa.peekFirst())) {
                coletarCarta(jogador2, i, true);
                coletou = true;
                break;
            } else if (podeColetar(carta, mesa.peekLast())) {
                coletarCarta(jogador2, i, false);
                coletou = true;
                break;
            }
        }

        // Se não coletou, posiciona a última carta na extremidade direita
        if (!coletou) {
            Carta cartaUsada = jogador2.removerCartaDaMao(jogador2.mao.size() - 1);
            mesa.addLast(cartaUsada);
        }

        // Comprar uma nova carta
        jogador2.adicionarCartaNaMao(monte.pop());
    }

    // Método para coletar cartas
    private void coletarCarta(Jogador jogador, int indexCartaMao, boolean coletarEsquerda) {
        Carta cartaUsada = jogador.removerCartaDaMao(indexCartaMao);
        if (coletarEsquerda) {
            while (!mesa.isEmpty() && mesa.peekFirst().nome.equals(cartaUsada.nome)) {
                jogador.coletarCarta(mesa.pollFirst());
            }
        } else {
            while (!mesa.isEmpty() && mesa.peekLast().nome.equals(cartaUsada.nome)) {
                jogador.coletarCarta(mesa.pollLast());
            }
        }
        jogador.coletarCarta(cartaUsada); // A carta usada também é coletada
    }

    // Verifica se uma carta pode ser coletada
    private boolean podeColetar(Carta cartaMao, Carta cartaMesa) {
        return cartaMao != null && cartaMesa != null && cartaMao.nome.equals(cartaMesa.nome);
    }

    // Método para simular a partida até o fim
    public void jogarPartida() {
        while (!monte.isEmpty()) {
            turnoJogador1();
            turnoJogador2();
        }

        // Exibe o resultado
        int cartasColetadasJ1 = jogador1.quantidadeColetada();
        int cartasColetadasJ2 = jogador2.quantidadeColetada();
        if (cartasColetadasJ1 > cartasColetadasJ2) {
            System.out.println(cartasColetadasJ1 + " " + cartasColetadasJ2 + " Jogador 1");
        } else if (cartasColetadasJ2 > cartasColetadasJ1) {
            System.out.println(cartasColetadasJ1 + " " + cartasColetadasJ2 + " Jogador 2");
        } else {
            System.out.println(cartasColetadasJ1 + " " + cartasColetadasJ2 + " Empate");
        }
    }

    // Leitura do arquivo com 100 partidas
    public static List<List<Carta>> lerCartasDoArquivo(String nomeArquivo) throws IOException {
        List<List<Carta>> montes = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] nomesCartas = linha.split(" ");
            List<Carta> monte = new ArrayList<>();
            for (String nome : nomesCartas) {
                monte.add(new Carta(nome));
            }
            montes.add(monte);
        }
        reader.close();
        return montes;
    }

    public static void main(String[] args) throws IOException {
        // Leitura das cartas do arquivo e simulação de 100 partidas
        List<List<Carta>> montes = lerCartasDoArquivo("/C://Users//Vini//Downloads//partidas (1).txt/");
        for (List<Carta> monte : montes) {
            Enferrujados jogo = new Enferrujados(monte);
            jogo.jogarPartida();
        }
    }
}

