
public class Estr_Fila {

    private Elemento_Fila inicio, fim, prox;
    Elemento_Fila elemento;

    public Estr_Fila(){
        this.inicio = this.fim = null;
    }

    /*
        Inserir/Enqueue:
        -Entrada: o Elemento_Fila a ser inserido
        -Saída: nenhuma
        -Efeito: o Elemento_Fila é inserido ao final da fila
    */
    public void InserirSimples(Elemento_Fila itemASerInserido){
        fim = fim.getProx();
        fim = itemASerInserido;
    }

    /*
        Retirar/Pop:
        -Entrada: nenhuma
        -Saída: o Elemento_Fila no início da fila
        -Efeito: o Elemento_Fila no início é removido da fila
    */
    public Elemento_Fila Pop(){
        Elemento_Fila saindo = inicio;
        inicio = inicio.getProx();
        return saindo;
    }

    /*
        Averiguar Primeiro Elemento/Peek:
        -Entrada: nenhuma
        -Saída: o Elemento_Fila no início da fila
        -Efeito: nenhum
    */
    public Elemento_Fila PeekInicio(){
        return inicio;
    }

    /*
        Averiguar Último Elemento/PeekEnd/PeekRear:
        -Entrada: nenhuma
        -Saída: o Elemento_Fila no final da fila
        -Efeito: nenhum
    */
    public Elemento_Fila PeekFim(){
        return fim;
    }

    /*
        EstaVazio/IsEmpty:
        -Entrada: nenhuma
        -Saída: boolean
        -Efeito: nenhum
    */
    public boolean EstaVazio(){
            return this.inicio == null;
        }

    public Elemento_Fila getElemento() {
        return elemento;
    }

    public void setElemento(Elemento_Fila elemento) {
        this.elemento = elemento;
    }

    }

    /*
        Tamanho/Size:
        -Entrada: nenhuma
        -Saída: int correspondente ao número de Elemento_Fila na fila
        -Efeito: nenhum
    */
    
    public int Tamanho(){
        int tamanho = 0;

        if(!this.EstaVazio()){
            Elemento_Fila elemento = inicio;

            while(elemento.prox != null){
                tamanho++;
                elemento = elemento.getProx();
            }
        }

        return tamanho;
    }

    
}