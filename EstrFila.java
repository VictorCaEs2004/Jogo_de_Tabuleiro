public class EstrFila {

    private ElementoFila inicio, fim, prox;
    ElementoFila elemento;

    public EstrFila() {
        this.inicio = this.fim = null;
    }

    /*
     * Inserir/Enqueue:
     * -Entrada: o ElementoFila a ser inserido
     * -Saída: nenhuma
     * -Efeito: o ElementoFila é inserido ao final da fila
     */
    public void inserirSimples(ElementoFila itemASerInserido) {
        fim = fim.getProx();
        fim = itemASerInserido;
    }

    /*
     * Retirar/Pop:
     * -Entrada: nenhuma
     * -Saída: o ElementoFila no início da fila
     * -Efeito: o ElementoFila no início é removido da fila
     */
    public ElementoFila pop() {
        ElementoFila saindo = inicio;
        inicio = inicio.getProx();
        return saindo;
    }

    /*
     * Averiguar Primeiro Elemento/Peek:
     * -Entrada: nenhuma
     * -Saída: o ElementoFila no início da fila
     * -Efeito: nenhum
     */
    public ElementoFila peekInicio() {
        return inicio;
    }

    /*
     * Averiguar Último Elemento/PeekEnd/PeekRear:
     * -Entrada: nenhuma
     * -Saída: o ElementoFila no final da fila
     * -Efeito: nenhum
     */
    public ElementoFila peekFim() {
        return fim;
    }

    /*
     * EstaVazio/IsEmpty:
     * -Entrada: nenhuma
     * -Saída: boolean
     * -Efeito: nenhum
     */
    public boolean estaVazio() {
        return this.inicio == null;
    }

    public ElementoFila getElemento() {
        return elemento;
    }

    public void setElemento(ElementoFila elemento) {
        this.elemento = elemento;
    }

    /*
     * Tamanho/Size:
     * -Entrada: nenhuma
     * -Saída: int correspondente ao número de ElementoFila na fila
     * -Efeito: nenhum
     */
    public int tamanho() {
        int tamanho = 0;
        if (!this.estaVazio()) {
            ElementoFila elemento = inicio;

            while (elemento.prox != null) {
                tamanho++;
                elemento = elemento.getProx();
            }
        }
        return tamanho;
    }
}