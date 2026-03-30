package listaencadeada;

import colecao.Icolecao;
import colecao.No;
import java.util.LinkedList;
import java.util.Objects;

public class ListaEncadeadaLinkedList<T> implements Icolecao<T> {

    private LinkedList<No<T>> listaEncadeadaLinkedList;

    public ListaEncadeadaLinkedList(){
        this.listaEncadeadaLinkedList = new LinkedList<>();
    }

    /**
     * @param novoValor O valor a ser adicionado à lista encadeada.
     * Este método cria um novo nó com o valor fornecido e o adiciona ao final da lista encadeada.
     */
    @Override
    public void adicionar(T novoValor) {

        No<T> novoNo = new No<>(novoValor);

        if (listaEncadeadaLinkedList == null) {
            listaEncadeadaLinkedList.add(novoNo);
        } else {
            No<T> atual = listaEncadeadaLinkedList.getLast();

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novoNo;
            listaEncadeadaLinkedList.add(novoNo);
        }
    }

    /**
     * @param valor O valor a ser pesquisado na lista encadeada.
     * Este método pesquisa o valor na lista encadeada usando LinkedList
     *  e retorna o mesmo se encontrado, ou null caso contrário.
     */
    @Override
    public T pesquisar(T valor) {
        No<T> atual = listaEncadeadaLinkedList.isEmpty() ? null : listaEncadeadaLinkedList.getFirst();

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
     * Este método remove o primeiro nó que contém o valor fornecido da lista encadeada usando LinkedList.
     */
    @Override
    public boolean remover(T valor) {
        No<T> atual = listaEncadeadaLinkedList.isEmpty() ? null : listaEncadeadaLinkedList.getFirst();
        No<T> anterior = null;

        while (atual != null) {
            if ((atual.valor == null && valor == null) || 
            (atual.valor != null && atual.valor.equals(valor)))
             {
                if (anterior == null) {
                    listaEncadeadaLinkedList.removeFirst();
                } else {
                    anterior.proximo = atual.proximo;
                    listaEncadeadaLinkedList.remove(atual);
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
        return listaEncadeadaLinkedList.size();
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
        No<T> atual = listaEncadeadaLinkedList.isEmpty() ? null : listaEncadeadaLinkedList.getFirst();
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