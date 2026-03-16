package colecao;

public interface Icolecao<T> {

    void adicionar(T novoValor);

    T pesquisar(T valor);

    boolean remover(T valor);

    int quantidadeNos();
}