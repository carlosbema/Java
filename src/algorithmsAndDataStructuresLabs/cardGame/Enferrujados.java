package algorithmsAndDataStructuresLabs.cardGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Enferrujados {

    public static void main(String[] args) {
        List<String> resultados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C://Users//Vini//Java//src//algorithmsAndDataStructuresLabs//cardGame//partidas.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String resultado = jogarPartida(linha);
                resultados.add(resultado);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo cartas.txt");
            e.printStackTrace();
            return;
        }

        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    public static String jogarPartida(String linhaDeck) {
        // Monte de cartas para compra: pilha
        Stack<String> monteCompra = new Stack<>();
        String[] cartasArray = linhaDeck.split(" ");
        for (int i = cartasArray.length - 1; i >= 0; i--) {
            monteCompra.push(cartasArray[i]);
        }

        // Cartas nas mãos dos jogadores: listas dinâmicas
        LinkedList<String> maoJogador1 = new LinkedList<>();
        LinkedList<String> maoJogador2 = new LinkedList<>();

        // Cartas coletadas pelos jogadores: pilhas
        Stack<String> coletadasJogador1 = new Stack<>();
        Stack<String> coletadasJogador2 = new Stack<>();

        // Cartas da mesa: deque
        Deque<String> mesa = new LinkedList<>();

        distribuirCartas(monteCompra, maoJogador1, 4);
        distribuirCartas(monteCompra, maoJogador2, 4);
        distribuirCartas(monteCompra, mesa, 4);

        boolean jogoTerminado = false;
        boolean vezJogador1 = true;

        while (!jogoTerminado) {
            if (vezJogador1) {
                realizarTurnoJogador1(monteCompra, mesa, maoJogador1, coletadasJogador1);
            } else {
                realizarTurnoJogador2(monteCompra, mesa, maoJogador2, coletadasJogador2);
            }

            vezJogador1 = !vezJogador1;

            if (monteCompra.isEmpty()) {
                jogoTerminado = true;
            }
        }

        int totalJogador1 = coletadasJogador1.size();
        int totalJogador2 = coletadasJogador2.size();

        String vencedor;
        if (totalJogador1 > totalJogador2) {
            vencedor = "Jogador 1";
        } else if (totalJogador2 > totalJogador1) {
            vencedor = "Jogador 2";
        } else {
            vencedor = "Empate";
        }

        return totalJogador1 + " " + totalJogador2 + " " + vencedor;
    }

    public static void distribuirCartas(Stack<String> monte, Collection<String> destino, int quantidade) {
        for (int i = 0; i < quantidade && !monte.isEmpty(); i++) {
            destino.add(monte.pop());
        }
    }

    public static void realizarTurnoJogador1(Stack<String> monteCompra, Deque<String> mesa, LinkedList<String> maoJogador, Stack<String> coletadasJogador) {
        boolean coletou = false;
        String cartaUsada = null;

        for (String cartaMao : maoJogador) {
            boolean podeColetarEsquerda = !mesa.isEmpty() && mesa.peekFirst().equals(cartaMao);
            boolean podeColetarDireita = !mesa.isEmpty() && mesa.peekLast().equals(cartaMao);

            if (podeColetarEsquerda || podeColetarDireita) {
                cartaUsada = cartaMao;
                maoJogador.remove(cartaUsada);
                if (podeColetarDireita) {
                    coletarCartas(mesa, cartaUsada, coletadasJogador, false);
                } else {
                    coletarCartas(mesa, cartaUsada, coletadasJogador, true);
                }
                coletou = true;
                break;
            }
        }

        if (!coletou) {
            cartaUsada = maoJogador.removeFirst();
            mesa.addFirst(cartaUsada);
        }

        if (!monteCompra.isEmpty()) {
            maoJogador.addLast(monteCompra.pop());
        }

        adicionarCartaMesa(monteCompra, mesa, coletou, cartaUsada, false);
    }

    public static void realizarTurnoJogador2(Stack<String> monteCompra, Deque<String> mesa, LinkedList<String> maoJogador, Stack<String> coletadasJogador) {
        boolean coletou = false;
        String cartaUsada = null;
        int maxCartasColetadas = 0;
        String cartaEscolhida = null;

        for (String cartaMao : maoJogador) {
            int numColetaEsquerda = contarCartasColetaveis(mesa, cartaMao, true);
            int numColetaDireita = contarCartasColetaveis(mesa, cartaMao, false);
            int maxColetavel = Math.max(numColetaEsquerda, numColetaDireita);

            if (maxColetavel > 0 && maxColetavel > maxCartasColetadas) {
                maxCartasColetadas = maxColetavel;
                cartaEscolhida = cartaMao;
            }
        }

        if (cartaEscolhida != null) {
            maoJogador.remove(cartaEscolhida);
            boolean coletaDireita = mesa.peekLast().equals(cartaEscolhida);

            if (coletaDireita) {
                coletarCartas(mesa, cartaEscolhida, coletadasJogador, false);
            } else {
                coletarCartas(mesa, cartaEscolhida, coletadasJogador, true);
            }
            coletou = true;
        }

        if (!coletou) {
            cartaUsada = maoJogador.removeLast();
            mesa.addLast(cartaUsada);
        }

        if (!monteCompra.isEmpty()) {
            maoJogador.addLast(monteCompra.pop());
        }

        adicionarCartaMesa(monteCompra, mesa, coletou, cartaUsada, true);
    }

    public static void coletarCartas(Deque<String> mesa, String cartaUsada, Stack<String> coletadasJogador, boolean esquerda) {
        coletadasJogador.push(cartaUsada);

        if (esquerda) {
            while (!mesa.isEmpty() && mesa.peekFirst().equals(cartaUsada)) {
                coletadasJogador.push(mesa.pollFirst());
            }
        } else {
            while (!mesa.isEmpty() && mesa.peekLast().equals(cartaUsada)) {
                coletadasJogador.push(mesa.pollLast());
            }
        }
    }

    public static int contarCartasColetaveis(Deque<String> mesa, String carta, boolean esquerda) {
        int contador = 0;
        Iterator<String> iterator;
        if (esquerda) {
            iterator = mesa.iterator();
        } else {
            iterator = mesa.descendingIterator();
        }

        while (iterator.hasNext()) {
            String cartaMesa = iterator.next();
            if (cartaMesa.equals(carta)) {
                contador++;
            } else {
                break;
            }
        }
        return contador;
    }

    public static void adicionarCartaMesa(Stack<String> monteCompra, Deque<String> mesa, boolean coletou, String cartaUsada, boolean jogador2) {
        if (monteCompra.isEmpty()) {
            return;
        }
        String cartaMesa = monteCompra.pop();

        if (coletou) {
            if (cartaUsada != null) {
                if (jogador2) {
                    boolean coletaDireita = mesa.peekLast() != null && mesa.peekLast().equals(cartaUsada);
                    if (coletaDireita) {
                        mesa.addLast(cartaMesa);
                    } else {
                        mesa.addFirst(cartaMesa);
                    }
                } else {
                    boolean coletaDireita = mesa.peekLast() != null && mesa.peekLast().equals(cartaUsada);
                    if (coletaDireita) {
                        mesa.addLast(cartaMesa);
                    } else {
                        mesa.addFirst(cartaMesa);
                    }
                }
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
}

