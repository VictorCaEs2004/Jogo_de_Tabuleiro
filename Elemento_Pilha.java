public class Elemento_Pilha{
    
    private Object item;
    private Elemento_Pilha prox;

    public Elemento_Pilha(Object tItem){
        this.item = tItem;
        this.prox = null;
    }

    public Elemento_Pilha getProx(){
        return prox;
    }

    public setProx(Elemento_Pilha proxElemento){
        this.prox = proxElemento;
    }
}