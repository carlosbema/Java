package algorithmsAndDataStructuresLabs.cardGame10;

import java.util.*;

// Classe que representa um jogador
class Jogador {
    private String nome;
    private LinkedList<String> mao; // Lista dinâmica
    private Stack<String> coletadas; // Pilha
    private boolean isJogador1;

    public Jogador(String nome, boolean isJogador1) {
        this.nome = nome;
        this.isJogador1 = isJogador1;
        this.mao = new LinkedList<>();
        this.coletadas = new Stack<>();
    }

    public String getNome() {
        return nome;
    }

    public void receberCarta(String carta) {
        mao.addLast(carta);
    }

    public int getTotalCartasColetadas() {
        return coletadas.size();
    }

    public boolean maoVazia() {
        return mao.isEmpty();
    }

    public void executarTurno(Deque<String> mesa, Stack<String> monte) {
        boolean coletou = false;
        String cartaUsada = null;
        boolean extremidadeEsquerda = false; // true para esquerda, false para direita

        if (isJogador1) {
            // Estratégia do Jogador 1
            for (String carta : mao) {
                if (carta.equals(mesa.peekFirst())) {
                    cartaUsada = carta;
                    extremidadeEsquerda = true;
                    break;
                } else if (carta.equals(mesa.peekLast())) {
                    cartaUsada = carta;
                    extremidadeEsquerda = false;
                    break;
                }
            }

            if (cartaUsada != null) {
                coletou = true;
                mao.remove(cartaUsada);
                coletarCartas(mesa, cartaUsada, extremidadeEsquerda);
            } else {
                // Descartar a primeira carta na extremidade esquerda
                String cartaDescartada = mao.removeFirst();
                mesa.addFirst(cartaDescartada);
                extremidadeEsquerda = true;
            }
        } else {
            // Estratégia do Jogador 2
            Map<String, Integer> possiveisColetas = new HashMap<>();
            for (String carta : mao) {
                int numCartasEsquerda = contarCartasExtremidade(mesa, carta, true);
                int numCartasDireita = contarCartasExtremidade(mesa, carta, false);
                int maxColeta = Math.max(numCartasEsquerda, numCartasDireita);
                if (maxColeta > 0) {
                    possiveisColetas.put(carta, maxColeta);
                }
            }

            if (!possiveisColetas.isEmpty()) {
                // Selecionar a carta que permite coletar o maior número de cartas
                String cartaEscolhida = null;
                int maxColeta = 0;
                for (String carta : mao) {
                    if (possiveisColetas.containsKey(carta)) {
                        int coleta = possiveisColetas.get(carta);
                        if (coleta > maxColeta) {
                            maxColeta = coleta;
                            cartaEscolhida = carta;
                        } else if (coleta == maxColeta && cartaEscolhida == null) {
                            cartaEscolhida = carta;
                        }
                    }
                }

                // Determinar a extremidade (direita em caso de empate)
                int numCartasEsquerda = contarCartasExtremidade(mesa, cartaEscolhida, true);
                int numCartasDireita = contarCartasExtremidade(mesa, cartaEscolhida, false);
                extremidadeEsquerda = numCartasDireita >= numCartasEsquerda ? false : true;

                coletou = true;
                mao.remove(cartaEscolhida);
                coletarCartas(mesa, cartaEscolhida, extremidadeEsquerda);
            } else {
                // Descartar a última carta na extremidade direita
                String cartaDescartada = mao.removeLast();
                mesa.addLast(cartaDescartada);
                extremidadeEsquerda = false;
            }
        }

        // Compra do monte
        if (!monte.isEmpty()) {
            String cartaComprada = monte.pop();
            mao.addLast(cartaComprada);
        }

        // Adicionar carta do monte à mesa
        if (!monte.isEmpty()) {
            String cartaMesa = monte.pop();
            if (coletou) {
                // Se houve coleta, adiciona na extremidade onde ocorreu a coleta
                if (extremidadeEsquerda) {
                    mesa.addFirst(cartaMesa);
                } else {
                    mesa.addLast(cartaMesa);
                }
            } else {
                // Se não houve coleta, adiciona na extremidade oposta ao descarte
                if (extremidadeEsquerda) {
                    mesa.addLast(cartaMesa);
                } else {
                    mesa.addFirst(cartaMesa);
                }
            }
        }
    }

    private void coletarCartas(Deque<String> mesa, String carta, boolean esquerda) {
        Stack<String> cartasColetadas = new Stack<>();
        cartasColetadas.push(carta); // Carta usada para coleta

        if (esquerda) {
            while (!mesa.isEmpty() && mesa.peekFirst().equals(carta)) {
                cartasColetadas.push(mesa.removeFirst());
            }
        } else {
            while (!mesa.isEmpty() && mesa.peekLast().equals(carta)) {
                cartasColetadas.push(mesa.removeLast());
            }
        }

        // Adicionar as cartas coletadas à pilha do jogador
        while (!cartasColetadas.isEmpty()) {
            coletadas.push(cartasColetadas.pop());
        }
    }

    private int contarCartasExtremidade(Deque<String> mesa, String carta, boolean esquerda) {
        int count = 0;
        if (esquerda) {
            Iterator<String> it = mesa.iterator();
            while (it.hasNext()) {
                String c = it.next();
                if (c.equals(carta)) {
                    count++;
                } else {
                    break;
                }
            }
        } else {
            Iterator<String> it = mesa.descendingIterator();
            while (it.hasNext()) {
                String c = it.next();
                if (c.equals(carta)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
