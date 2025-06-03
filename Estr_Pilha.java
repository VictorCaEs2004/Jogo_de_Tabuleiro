public class Estr_Pilha{

    private Elemento_Pilha topo;

    public Estr_Pilha(){
        this.topo = null;
    }

    public Estr_Pilha(Elemento_Pilha topo) {
        this.topo = topo;
    }

    public void Inserir(Elemento_Pilha elmntAInserir){
        elmntAInserir.setProx(topo);
        topo = elmntAInserir;
    }

    public Elemento_Pilha Pop(){
        Elemento_Pilha elmPop = topo;
        topo = topo.getProx();
        return elmPop;
    }

    public Elemento_Pilha Peek(){
        return topo;
    }

    public boolean EstaVazio(){
        return topo == null;
    }

    public int Tamanho(){
        int tamanho = 0;
        if(!this.EstaVazio()){
            tamanho++;
            Elemento_Pilha elementoContado = topo;
            while(elementoContado.getProx() != null){
                tamanho++;
                elementoContado = elementoContado.getProx();
            }
        }
        return tamanho;
    }
}