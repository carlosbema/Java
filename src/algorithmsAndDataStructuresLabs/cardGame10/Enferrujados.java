package algorithmsAndDataStructuresLabs.cardGame10;

// Classe principal do jogo Enferrujados
import java.io.*;
import java.util.*;

public class Enferrujados {

    public static void main(String[] args) {
        String arquivoCartas = "src//partidas.txt";
        List<String> linhasCartas = lerArquivo(arquivoCartas);

        for (int i = 0; i < linhasCartas.size(); i++) {
            System.out.println("=== Partida " + (i + 1) + " ===");
            String linhaCartas = linhasCartas.get(i);
            List<String> cartas = new ArrayList<>(Arrays.asList(linhaCartas.split("\\s+")));

            Jogo jogo = new Jogo(cartas);
            jogo.simularPartida();
            System.out.println();
        }
    }

    // Função para ler o arquivo de cartas
    public static List<String> lerArquivo(String nomeArquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha.trim());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return linhas;
    }
}