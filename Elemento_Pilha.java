public class Elemento_Pilha{
    
    private final Object item;
    public Elemento_Pilha prox;

    public Elemento_Pilha(Object tItem){
        this.item = tItem;
        this.prox = null;
    }

    

    public Elemento_Pilha getProx(){
        return prox;
    }

    public void setProx(Elemento_Pilha proxElemento){
        this.prox = proxElemento;
    }
    
    public Object getItem(){
        return item;
    }
}