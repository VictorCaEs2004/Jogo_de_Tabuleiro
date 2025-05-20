public class ListaDuplamenteEncadeada {
    public Node primeiro, ultimo, atual;

    public ListaDuplamenteEncadeada() {
        this.primeiro = this.ultimo = this.atual = null;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void inserirUltimo(int info) {
        Node node = new Node(info);
        if (estaVazia()) {
            primeiro = ultimo = node;
        } else {
            ultimo.prox = node;
            node.prev = ultimo;
            ultimo = node;
        }
    }

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
        System.out.println("Moveu " + valor + " casa(s) para frente, parando na " + atual.info + ".");
    }

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
        System.out.println("Moveu " + valor + " casa(s) para trás, parando na " + atual.info + ".");
    }

    public void mostrarLista() {
        for (Node node = primeiro; node != null; node = node.prox) {
            System.out.println(node.info);
        }
    }
}