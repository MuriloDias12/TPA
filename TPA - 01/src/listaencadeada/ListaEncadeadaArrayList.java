package listaencadeada;

import colecao.Icolecao;
import colecao.No;
import java.util.ArrayList;
import java.util.Objects;

public class ListaEncadeadaArrayList<T> implements Icolecao<T> {

    private ArrayList<No<T>> listaEncadeadaArrayList;

    public ListaEncadeadaArrayList(){
        this.listaEncadeadaArrayList = new ArrayList<>();
    }

    /**
     * @param novoValor O valor a ser adicionado à lista encadeada.
     * Este método cria um novo nó com o valor fornecido e o adiciona ao final da lista encadeada.
     */
    @Override
    public void adicionar(T novoValor) {

        No<T> novoNo = new No<>(novoValor);

        if (listaEncadeadaArrayList == null) {
            listaEncadeadaArrayList.add(novoNo);
        } else {
            No<T> atual = listaEncadeadaArrayList.get(listaEncadeadaArrayList.size() - 1);

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novoNo;
            listaEncadeadaArrayList.add(novoNo);
        }
    }

    /**
     * @param valor O valor a ser pesquisado na lista encadeada.
     * Este método pesquisa o valor na lista encadeada e retorna o mesmo se encontrado, ou null caso contrário.
     */
    @Override
    public T pesquisar(T valor) {
        No<T> atual = listaEncadeadaArrayList.isEmpty() ? null : listaEncadeadaArrayList.get(0);

        while (atual != null) {
            if (Objects.equals(atual.valor, valor)) {
                return atual.valor;
            }
            atual = atual.proximo;
        }
        return null;
    }
    
    /**
     * @param valor O valor a ser removido da lista encadeada.
     * Este método remove o primeiro nó que contém o valor fornecido da lista encadeada.
     */
    @Override
    public boolean remover(T valor) {
        No<T> atual = listaEncadeadaArrayList.isEmpty() ? null : listaEncadeadaArrayList.get(0);
        No<T> anterior = null;

        while (atual != null) {
            if ((atual.valor == null && valor == null) || 
            (atual.valor != null && atual.valor.equals(valor)))
             {
                if (anterior == null) {
                    listaEncadeadaArrayList.remove(0);
                } else {
                    anterior.proximo = atual.proximo;
                    listaEncadeadaArrayList.remove(atual);
                }
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        return false;
    }

    /**
     * @return O número de nós na lista encadeada.
     * Este método retorna a quantidade de nós presentes na lista encadeada, 
     * utilizando o tamanho do ArrayList para fazer a contagem.
     */
    @Override
    public int quantidadeNos() {
        return listaEncadeadaArrayList.size();
    }

    /**
     * Este método retorna uma representação em string da lista encadeada,
     * onde cada valor dos nós é separado por vírgula. Se um valor for null, 
     * ele será representado como "null" na string resultante.
     * @return Uma string representando os valores dos nós na lista encadeada, separados por vírgula.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> atual = listaEncadeadaArrayList.isEmpty() ? null : listaEncadeadaArrayList.get(0);
        boolean first = true;

        while (atual != null) {
            if (!first) {
                sb.append(",");
            }
            sb.append(atual.valor == null ? "null" : atual.valor.toString());
            first = false;
            atual = atual.proximo;
        }

        return sb.toString();
    }
}