package algorithmsAndDataStructuresLabs.cardGame2.Program;

import algorithmsAndDataStructuresLabs.cardGame2.entities.Jogo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Enferrujados {

    public static void main(String[] args) {
        List<String> resultados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/C://Users//Vini//Downloads//partidas (1).txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Jogo jogo = new Jogo(linha);
                String resultado = jogo.jogar();
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
}
