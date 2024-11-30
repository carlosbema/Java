package algorithmsAndDataStructuresLabs.Trab2;

import java.io.*;
import java.util.*;

public class aloca_provas {
    private static class Graph {
        private final int V;
        private final List<List<Integer>> adj;
        private final int[] colors;

        public Graph(int v) {
            V = v;
            adj = new ArrayList<>(v);
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
            colors = new int[v];
            Arrays.fill(colors, -1);
        }

        public void addEdge(int u, int v) {
            adj.get(u-1).add(v-1);
            adj.get(v-1).add(u-1);
        }

        private int calculateScore(int vertex, int algorithm) {
            switch (algorithm) {
                case 1: // Grau do vértice
                    return adj.get(vertex).size();

                case 2: // Número de vizinhos coloridos
                    int coloredNeighbors = 0;
                    for (int neighbor : adj.get(vertex)) {
                        if (colors[neighbor] != -1) {
                            coloredNeighbors++;
                        }
                    }
                    return coloredNeighbors;

                case 3: // Número de vizinhos não coloridos
                    int uncoloredNeighbors = 0;
                    for (int neighbor : adj.get(vertex)) {
                        if (colors[neighbor] == -1) {
                            uncoloredNeighbors++;
                        }
                    }
                    return uncoloredNeighbors;

                case 4: // Nova estratégia: Grau + Diversidade de cores na vizinhança
                    Set<Integer> uniqueColors = new HashSet<>();
                    for (int neighbor : adj.get(vertex)) {
                        if (colors[neighbor] != -1) {
                            uniqueColors.add(colors[neighbor]);
                        }
                    }
                    // Pontuação = grau do vértice + número de cores diferentes já usadas
                    return adj.get(vertex).size() + uniqueColors.size();

                default:
                    return 0;
            }
        }

        private boolean isColorValid(int vertex, int color) {
            for (int neighbor : adj.get(vertex)) {
                if (colors[neighbor] == color) {
                    return false;
                }
            }
            return true;
        }

        public int solveColoring(int algorithm) {
            int maxColor = 0;
            Set<Integer> uncolored = new HashSet<>();

            for (int i = 0; i < V; i++) {
                uncolored.add(i);
            }

            while (!uncolored.isEmpty()) {
                int maxScore = -1;
                int selectedVertex = -1;

                for (int vertex : uncolored) {
                    int score = calculateScore(vertex, algorithm);
                    if (score > maxScore) {
                        maxScore = score;
                        selectedVertex = vertex;
                    }
                }

                int color = 1;
                while (!isColorValid(selectedVertex, color)) {
                    color++;
                }

                colors[selectedVertex] = color;
                maxColor = Math.max(maxColor, color);
                uncolored.remove(selectedVertex);
            }

            return maxColor;
        }
    }

    public static Graph readGraphFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            Graph graph = null;

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts[0].equals("p")) {
                    int V = Integer.parseInt(parts[2]);
                    graph = new Graph(V);
                }
                else if (parts[0].equals("e")) {
                    if (graph == null) {
                        throw new IOException("Arquivo inválido: arestas antes da definição do grafo");
                    }
                    int u = Integer.parseInt(parts[1]);
                    int v = Integer.parseInt(parts[2]);
                    graph.addEdge(u, v);
                }
            }

            if (graph == null) {
                throw new IOException("Arquivo inválido: sem definição do grafo");
            }

            return graph;
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: aloca_provas <algoritmo> <arquivo_sala>");
            return;
        }

        try {
            int algorithm = Integer.parseInt(args[0]);
            String filename = args[1];

            if (algorithm < 1 || algorithm > 4) {
                System.out.println("Algoritmo deve ser 1, 2, 3 ou 4");
                return;
            }

            Graph graph = readGraphFromFile(filename);
            int result = graph.solveColoring(algorithm);
            System.out.println(result);

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Algoritmo deve ser um número");
        }
    }
}