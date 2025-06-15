public class ListaDuplamenteEncadeada {
    public Node primeiro, ultimo, atual;
    public Controle controle;

    public ListaDuplamenteEncadeada(Controle controle) {
        this.primeiro = this.ultimo = this.atual = null;
        this.controle = controle;
    }

    /*
     * EstaVazio/IsEmpty
     * -Entrada: nenhuma
     * -Saída: boolean
     * -Efeito: retorna se a lista dupla está vazia ou não
     */
    public boolean estaVazio() {
        return primeiro == null;
    }

    /*
     * InserirUltimo/InsertAtEnd
     * -Entrada: o dado do nó a ser inserido
     * -Saída: nenhuma
     * -Efeito: insere nó ao fim da lista dupla
     */
    public void inserirUltimo(int info) {
        Node node = new Node(info);
        if (estaVazio()) {
            primeiro = ultimo = node;
        } else {
            ultimo.prox = node;
            node.prev = ultimo;
            ultimo = node;
        }
    }

    /*
     * Avancar/TraverseForward
     * -Entrada: posição do nó atual e do nó destino
     * -Saída: nenhuma
     * -Efeito: se movimenta da posição atual até destino
     */
    public void avancar(int posicao, int valor) {
        atual = primeiro;
        if (posicao != 1) {
            int posicaoAtual = 1;
            while (atual != null && posicaoAtual < posicao) {
                atual = atual.prox;
                posicaoAtual++;
            }
        }
        for (int i = 0; i < valor; i++) {
            atual = atual.prox;
        }
        controle.stringBuilder.append("\nMoveu " + valor + " casa(s) para frente, parando na " + atual.info + ".");
        //System.out.println("Moveu " + valor + " casa(s) para frente, parando na " + atual.info + ".");
    }

    /*
     * Retroceder/TraverseBackward
     * -Entrada: posição do nó atual e do nó destino
     * -Saída: nenhuma
     * -Efeito: se movimenta da posição atual até destino
     */
    public void retroceder(int posicao, int valor) {
        atual = primeiro;
        if (posicao != 1) {
            int posicaoAtual = 1;
            while (atual != null && posicaoAtual < posicao) {
                atual = atual.prox;
                posicaoAtual++;
            }
        }
        for (int i = 0; i < valor; i++) {
            atual = atual.prev;
        }
        //System.out.println("Moveu " + valor + " casa(s) para trás, parando na " + atual.info + ".");
        controle.stringBuilder.append("\nMoveu " + valor + " casa(s) para trás, parando na " + atual.info + ".");
    }
}