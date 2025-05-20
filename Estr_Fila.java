public class Estr_Fila {

    private Elemento_Fila inicio, fim;

    public Estr_Fila(Elemento_Fila iInicio, Elemento_Fila iFim){
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
}