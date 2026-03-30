package gerador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class GeradorArquivos {
    private static final String[] NOME_ARQUIVOS = {"produtos_10k.txt", "produtos_20k.txt", "produtos_40k.txt", "produtos_80k.txt", "produtos_200k.txt", "produtos_400k.txt"};
    private static final int[] QUANTIDADES = {10000, 20000, 40000, 80000};

    public static void main(String[] args) throws IOException {
        //vai gerar os arquivos de produtos com as quantidades especificadas rodando automaticamente as 4 vezes
        for (int i = 0; i < QUANTIDADES.length; i++) {
            gerarArquivo(NOME_ARQUIVOS[i], QUANTIDADES[i]);
        }
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