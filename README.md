# TPA-01 — Análise de Complexidade em Estruturas de Listas

Trabalho prático da disciplina de Tópicos em Programação Avançada.  
**Grupo:** Murilo Dias, Mickele

---

## 📋 Descrição

Este projeto implementa uma biblioteca de lista encadeada genérica em Java, além de programas de teste e análise empírica de complexidade. O objetivo é comparar o desempenho de três implementações de listas: a biblioteca própria (`ListaEncadeada`), e as implementações padrão do Java (`ArrayList` e `LinkedList`).

---

## 📁 Estrutura do Projeto

```
TPA-01/
├── src/
│   ├── colecao/
│   │   ├── Icolecao.java        # Interface genérica da coleção
│   │   └── No.java              # Classe que representa um nó da lista
│   ├── listaencadeada/
│   │   └── ListaEncadeada.java  # Implementação própria de lista encadeada
│   ├── dominio/
│   │   └── Produto.java         # Classe de domínio com equals e toString
│   ├── analise/
│   │   └── AnaliseTempo.java    # Programa de medição de tempos de execução
│   ├── gerador/
│   │   └── GeradorArquivos.java # Gerador de arquivos de entrada
│   └── Main.java                # Programa interativo de teste
├── produtos_10k.txt
├── produtos_20k.txt
├── produtos_40k.txt
├── produtos_80k.txt
└── README.md
```

---

## 🚀 Como Rodar

### Pré-requisitos
- Java JDK 11 ou superior
- VSCode com extensão Java ou qualquer IDE Java

### 1. Gerar os arquivos de entrada
Execute a classe `GeradorArquivos.java` para gerar os arquivos `.txt` com os dados de produtos:
```
src/gerador/GeradorArquivos.java
```
Os arquivos serão gerados na raiz do projeto com 10k, 20k, 40k e 80k registros.

### 2. Rodar o programa interativo
Execute a classe `Main.java` para interagir com a lista — adicionar, remover, pesquisar e listar produtos:
```
src/Main.java
```

### 3. Rodar a análise de tempos
Execute a classe `AnaliseTempo.java` para medir os tempos de execução de cada operação nos diferentes arquivos:
```
src/analise/AnaliseTempo.java
```

---

## 🗂️ Descrição das Classes

| Classe | Pacote | Descrição |
|---|---|---|
| `Icolecao` | `colecao` | Interface genérica com os métodos `adicionar`, `pesquisar`, `remover` e `quantidadeNos` |
| `No` | `colecao` | Representa um nó da lista, armazenando valor e referência para o próximo nó |
| `ListaEncadeada` | `listaencadeada` | Implementação própria de lista encadeada simples genérica |
| `Produto` | `dominio` | Classe de domínio com atributos `id`, `nome` e `preco`, com `equals` e `toString` sobrescritos |
| `GeradorArquivos` | `gerador` | Gera arquivos `.txt` com produtos aleatórios em formato `id;nome;preco` |
| `AnaliseTempo` | `analise` | Lê os arquivos gerados, insere na lista e mede o tempo de cada operação |
| `Main` | — | Menu interativo para manipulação da lista de produtos |

---

## 📊 Formato dos Arquivos de Entrada

Os arquivos gerados seguem o formato:
```
<quantidade_de_registros>
<id>;<nome>;<preco>
<id>;<nome>;<preco>
...
```

Exemplo:
```
10000
1;Produto1;199.99
2;Produto2;549.30
3;Produto3;89.90
```
