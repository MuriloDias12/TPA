package gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class GeradorArquivos {
    private static final String NOME_ARQUIVO = "produtos_80k.txt";
    private static final int NUM_REGISTROS =80000;

    public static void main(String[] args) throws IOException {
        gerarArquivo(NOME_ARQUIVO, NUM_REGISTROS);
        // rode 3 vezes mudando o nome e quantidade:
        // produtos_200k.txt -> 200000
        // produtos_400k.txt -> 400000
    }

    private static void gerarArquivo(String nomeArquivo, int quantidade) throws IOException {
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(nomeArquivo, StandardCharsets.UTF_8))) {

            writer.write(quantidade + "\n"); // primeira linha é a quantidade

            for (int i = 1; i <= quantidade; i++) {
                String nome = "Produto" + i;
                double preco = 10 + (random.nextDouble() * 990);
                writer.write(i + ";" + nome + ";" + 
                    String.format("%.2f", preco).replace(',', '.') + "\n");
            }

            System.out.println("Gerado: " + nomeArquivo + " com " + quantidade + " registros");
        }
    }
}