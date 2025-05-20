public class Estr_Fila {

    private Elemento_Fila inicio, fim;

    public Estr_Fila(){
        this.inicio = this.fim = null;
    }

    public void InserirSimples(Elemento_Fila itemASerInserido){
        fim.prox = itemASerInserido;
        fim = itemASerInserido;
    }

    public Elemento_Fila Pop(){
        Elemento_Fila saindo = inicio;
        inicio = inicio.prox;
        return saindo;
    }

    public Elemento_Fila PeekInicio(){
        return inicio;
    }

    public Elemento_Fila PeekFim(){
        return fim;
    }

    public boolean EstaVazio(){
        if(this.inicio == null){
            return true;
        }
        return false;
    }

    public int Tamanho(){
        int tamanho = 0;
        if(!this.EstaVazio()){
            Elemento_Fila elemento = inicio;
            while(elemento.prox != null){
                tamanho++;
                elemento = elemento.prox;
            }
        }

        return tamanho;
    }
}