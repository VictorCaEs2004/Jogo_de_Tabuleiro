public class ElementoFila {

    public String item;
    private ElementoFila prox;

    public ElementoFila(String item){
        this.item = item;
        this.prox = null;
    }

    public String getItem() {
        return item;
    }

    public ElementoFila getProx(){
        if(prox == null){
            return null;
        }else{
            return prox;
        }
    }

    public void setProx(ElementoFila prox){
        this.prox = prox;
    }
    
}
