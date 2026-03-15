package listaencadeada;

import colecao.Icolecao;
import colecao.No;

public class ListaEncadeada<T> implements Icolecao<T> {

    private No<T> inicio;
    private int quantidade;

    public ListaEncadeada(){
        this.inicio = null;
        this.quantidade = 0;
    }

    @Override
    public void adicionar(T novoValor) {

    }

    @Override
    public T pesquisar(T valor) {
        return null;
    }
    @Override
    public boolean remover(T valor) {

        return false;
    }
    @Override
    public int quantidadeNos() {
        return 0;
    }


}