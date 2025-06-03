public class Elemento_Fila {

    public Object item;
    private Elemento_Fila prox;

    public Elemento_Fila(Object item){
        this.item = item;
        this.prox = null;
    }

    public Elemento_Fila getProx(){
        return prox;
    }

    public void setProx(Elemento_Fila prox){
        this.prox = prox;
    }
    
}
