package listaencadeada;

import colecao.Icolecao;
import colecao.No;
import java.util.Objects;

public class ListaEncadeada<T> implements Icolecao<T> {

    private No<T> inicio;
    private int quantidade;

    public ListaEncadeada(){
        this.inicio = null;
        this.quantidade = 0;
    }


    @Override
    public void adicionar(T novoValor) {

        No<T> novoNo = new No<>(novoValor);

        if (inicio == null) {
            inicio = novoNo;
        } else {
            No<T> atual = inicio;

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novoNo;
        }

        quantidade++;
    }

    @Override
    public T pesquisar(T valor) {
        No<T> atual = inicio;

        while (atual != null) {
            if (Objects.equals(atual.valor, valor)) {
                return atual.valor;
            }
            atual = atual.proximo;
        }

        return null;
    }
    
    @Override
    public boolean remover(T valor) {
        No<T> atual = inicio;
        No<T> anterior = null;

        while (atual != null) {
            if ((atual.valor == null && valor == null) || 
            (atual.valor != null && atual.valor.equals(valor)))
             {
                if (anterior == null) {
                    inicio = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }

                quantidade--;
                return true;
            }

            anterior = atual;
            atual = atual.proximo;
        }

        return false;
    }
    @Override
    public int quantidadeNos() {
        return quantidade;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        No<T> atual = inicio;
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