// Exemplo de uso de ListaEncadeada
import listaencadeada.ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();

        System.out.println("Adicionando: A, B, C, B");
        lista.adicionar("A");
        lista.adicionar("B");
        lista.adicionar("C");
        lista.adicionar("B");
       
        System.out.println(lista);

        System.out.println("Quantidade (esperado 4): " + lista.quantidadeNos());

        String encontrado = lista.pesquisar("B");
        System.out.println("Pesquisar 'B' -> " + (encontrado != null ? encontrado : "não encontrado"));

        boolean removido = lista.remover("B");
        System.out.println("Remover 'B' -> " + removido + " (quantidade agora: " + lista.quantidadeNos() + ")");

        boolean removidoNaoExiste = lista.remover("X");
        System.out.println("Remover 'X' (não existe) -> " + removidoNaoExiste + " (quantidade: " + lista.quantidadeNos() + ")");
    }
        
}
