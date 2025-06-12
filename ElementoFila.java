public class ElementoFila {

    public Object item;
    private ElementoFila prox;

    public ElementoFila(Object item){
        this.item = item;
        this.prox = null;
    }

    public ElementoFila getProx(){
        return prox;
    }

    public void setProx(ElementoFila prox){
        this.prox = prox;
    }
    
}
