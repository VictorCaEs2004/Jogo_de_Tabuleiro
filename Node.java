public class Node {
    public int info;
    public Node prox, prev;

    public Node(int info) {
        this.info = info;
        this.prev = null;
        this.prox = null;
    }

    public Node(int info, Node prev, Node prox) {
        this.info = info;
        this.prev = prev;
        this.prox = prox;
    }
}