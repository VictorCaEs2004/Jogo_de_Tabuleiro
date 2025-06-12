public class ElementoPilha {

    private final Carta item;
    public ElementoPilha prox;

    public ElementoPilha(Carta tItem) {
        this.item = tItem;
        this.prox = null;
    }

    public ElementoPilha getProx() {
        return prox;
    }

    public void setProx(ElementoPilha proxElemento) {
        this.prox = proxElemento;
    }

    public Carta getItem() {
        return item;
    }
}