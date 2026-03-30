package analise;

import colecao.Icolecao;
import dominio.Produto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import listaencadeada.ListaEncadeada;

public class AnaliseTempo {

    public static void analisar(String nomeArquivo) throws IOException {
        Icolecao<Produto> lista = new ListaEncadeada<>();
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        Produto ultimoProduto = null;

        br.readLine(); // pula a primeira linha (quantidade de registros)

        System.out.println("\n=== Arquivo: " + nomeArquivo + " ===");

        long inicio = System.currentTimeMillis();
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] partes = linha.split(";");
            int id = Integer.parseInt(partes[0]);
            String nome = partes[1];
            double preco = Double.parseDouble(partes[2]);
            ultimoProduto = new Produto(id, nome, preco);
            lista.adicionar(ultimoProduto);
        }
        long fim = System.currentTimeMillis();
        br.close();
        System.out.println("Tempo de leitura e inserção: " + (fim - inicio) + "ms");

        // Aquecimento da JVM (não medido)
        for (int i = 0; i < 100; i++) {
            lista.pesquisar(ultimoProduto);
            lista.pesquisar(new Produto(-1, "", 0));
        }

        // 2 - Pesquisa pelo último elemento (pior caso)
        long inicioNano = System.nanoTime();
        lista.pesquisar(ultimoProduto);
        long fimNano = System.nanoTime();
        System.out.println("Tempo pesquisar (último elemento): " + 
            (fimNano - inicioNano) / 1_000_000.0 + "ms");

        // 3 - Pesquisa por elemento inexistente (pior caso)
        Produto inexistente = new Produto(-1, "", 0);
        inicioNano = System.nanoTime();
        lista.pesquisar(inexistente);
        fimNano = System.nanoTime();
        System.out.println("Tempo pesquisar (não existe): " + 
            (fimNano - inicioNano) / 1_000_000.0 + "ms");

        // 4 - Remove o último elemento
        inicioNano = System.nanoTime();
        lista.remover(ultimoProduto);
        fimNano = System.nanoTime();
        System.out.println("Tempo remover (último elemento): " + 
            (fimNano - inicioNano) / 1_000_000.0 + "ms");

        // 5 - Quantidade de nós
        inicioNano = System.nanoTime();
        int qtd = lista.quantidadeNos();
        fimNano = System.nanoTime();
        System.out.println("Tempo quantidadeNos: " + 
            (fimNano - inicioNano) / 1_000_000.0 + "ms | Qtd: " + qtd);
    }

    public static void main(String[] args) throws IOException {
        String[] arquivos = {
            "produtos_10k.txt",
            "produtos_20k.txt",
            "produtos_40k.txt",
            "produtos_80k.txt"
        };

        for (String arquivo : arquivos) {
            analisar(arquivo);
        }
    }
}