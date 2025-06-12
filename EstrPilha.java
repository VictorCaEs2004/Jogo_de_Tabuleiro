public class EstrPilha {
    private ElementoPilha topo;

    public EstrPilha() {
        this.topo = null;
    }

    public EstrPilha(ElementoPilha topo) {
        this.topo = topo;
    }

    /*
     * Inserir/Push:
     * -Entrada: o ElementoPilha a ser inserido
     * -Saída: nenhuma
     * -Efeito: o ElementoPilha é inserido ao topo da pilha
     */
    public void push(ElementoPilha elmntAInserir) {
        elmntAInserir.setProx(topo);
        topo = elmntAInserir;
    }

    /*
     * Retirar/Pop:
     * -Entrada: nenhuma
     * -Saída: o elemento retirado
     * -Efeito: retorna e remove o elemento no topo da pilha
     */
    public ElementoPilha pop() {
        ElementoPilha elmPop = topo;
        topo = topo.getProx();
        return elmPop;
    }

    /*
     * Averiguar/Peek:
     * -Entrada: nenhuma
     * -Saída: topo
     * -Efeito: retorna o elemento no topo da pilha
     */
    public ElementoPilha peek() {
        return topo;
    }

    /*
     * EstaVazio/IsEmpty:
     * -Entrada: nenhuma
     * -Saída: boolean
     * -Efeito: retorna se a pilha está vazia ou não
     */
    public boolean estaVazio() {
        return topo == null;
    }

    /*
     * Tamanho/Size:
     * -Entrada: nenhuma
     * -Saída: tamanho
     * -Efeito: retorna a quantidade de elementos na pilha
     */
    public int tamanho() {
        int tamanho = 0;
        if (!this.estaVazio()) {
            tamanho++;
            ElementoPilha elementoContado = topo;
            while (elementoContado.getProx() != null) {
                tamanho++;
                elementoContado = elementoContado.getProx();
            }
        }
        return tamanho;
    }
}